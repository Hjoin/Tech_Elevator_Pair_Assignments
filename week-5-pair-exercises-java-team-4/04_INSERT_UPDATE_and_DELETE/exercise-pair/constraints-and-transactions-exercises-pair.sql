-- Write queries to return the following:
-- Make the following changes in the "world" database.

-- 1. Add Superman's hometown, Smallville, Kansas to the city table. The
-- countrycode is 'USA', and population of 45001.
INSERT INTO city (name, district, countrycode, population)
VALUES ('Smallville', 'Kansas', 'USA', 45001);

SELECT *
FROM city
WHERE name = 'Smallville';
-- ROLLBACK;

-- 2. Add Kryptonese to the countrylanguage table. Kryptonese is spoken by 0.0001
-- percentage of the 'USA' population.
INSERT INTO countrylanguage (countrycode, language, isofficial, percentage)
VALUES ('USA', 'Kryptonese', false, .0001);

SELECT *
FROM countrylanguage
WHERE language = 'Kryptonese';
--ROLLBACK;

-- 3. After heated debate, "Kryptonese" was renamed to "Krypto-babble." Change
-- the appropriate record accordingly.
UPDATE countrylanguage
SET language = 'Krypto-babble'
WHERE language = 'Kryptonese';

SELECT *
FROM countrylanguage
WHERE countrycode = 'USA';
--ROLLBACK;

-- 4. Set the US capital to Smallville, Kansas in the country table.
UPDATE country
SET capital = (SELECT id FROM city WHERE name = 'Smallville')
WHERE code = 'USA';

SELECT capital
FROM country
WHERE code = 'USA';
--ROLLBACK;

-- 5. Delete Smallville, Kansas from the city table. (Did it succeed? Why?)
START TRANSACTION;
DELETE
FROM city
WHERE name = 'Smallville' AND district = 'Kansas';

ROLLBACK;

-- No, it did not succeed because the Smallville id is being used as a foreign ket in the country table (violates the foreign key constraint)

-- 6. Return the US capital to Washington.
UPDATE country
SET capital = (SELECT id FROM city WHERE name = 'Washington' AND district ILIKE 'District of Columbia')
WHERE code = 'USA';

SELECT city.name
FROM city
INNER JOIN country ON city.countrycode = country.code
WHERE city.id = country.capital AND country.code = 'USA';

-- 7. Delete Smallville, Kansas from the city table. (Did it succeed? Why?)
DELETE
FROM city
WHERE name = 'Smallville' AND district = 'Kansas';

SELECT name
FROM city
WHERE name = 'Smallville' AND district = 'Kansas';

-- Yes, it succeeded.

-- 8. Reverse the "is the official language" setting for all languages where the
-- country's year of independence is within the range of 1800 and 1972
-- (exclusive).
-- (590 rows affected)
SELECT c.name, cl.language, cl.isofficial
FROM countrylanguage AS cl
        INNER JOIN country AS c
        ON cl.countrycode = c.code
WHERE c.indepyear BETWEEN 1800 AND 1972
ORDER BY c.indepyear
Limit 10;

UPDATE countrylanguage
SET isofficial = NOT isofficial
WHERE countrycode IN (SELECT code FROM country WHERE indepyear BETWEEN 1800 AND 1972);

SELECT c.name, cl.language, cl.isofficial
FROM countrylanguage AS cl
        INNER JOIN country AS c
        ON cl.countrycode = c.code
WHERE c.indepyear BETWEEN 1800 AND 1972
ORDER BY c.indepyear
Limit 10;

-- 9. Convert population so it is expressed in 1,000s for all cities. (Round up to
-- the nearest integer value.)
-- (4079 rows affected)

SELECT population
FROM city
ORDER BY population DESC
LIMIT 50;

UPDATE city
SET population = (population::numeric/1000)::integer;

SELECT population
FROM city
ORDER BY population DESC
LIMIT 50;

--ROLLBACK;

-- 10. Assuming a country's surfacearea is expressed in square miles, convert it to
-- square meters for all countries where French is spoken by more than 20% of the
-- population.
-- (7 rows affected)

UPDATE country
SET surfacearea = surfacearea * 2589988.11
WHERE code IN(SELECT countrycode FROM countrylanguage WHERE language ILIKE 'French' AND percentage > 20);

SELECT l.countrycode, co.surfacearea, l.language, l.percentage
FROM countrylanguage AS l
INNER JOIN country AS co
ON co.code = l.countrycode
WHERE language ILIKE 'French' AND percentage > 20
ORDER BY co.surfacearea DESC;

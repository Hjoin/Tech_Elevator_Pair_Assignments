-- Write queries to return the following:
-- The following queries utilize the "world" database.

-- 1. The city name, country name, and city population of all cities in Europe with population greater than 1 million
-- (36 rows)
SELECT c.name, co.name, c.population
FROM city AS c
INNER JOIN country AS co
ON c.countrycode = co.code
WHERE c.population > 1000000 AND co.continent ILIKE 'Europe';

-- 2. The city name, country name, and city population of all cities in countries where French is an official language and the city population is greater than 1 million
-- (2 rows)
SELECT c.name, co.name, c.population
FROM city AS c
INNER JOIN country AS co
ON c.countrycode = co.code
INNER JOIN countrylanguage as l
ON co.code = l.countrycode
WHERE c.population > 1000000 AND (l.language = 'French' AND l.isofficial = true);


-- 3. The name of the countries and continents where the language Javanese is spoken
-- (1 row)
SELECT co.name, co.continent
FROM country AS co
INNER JOIN countrylanguage AS l
ON co.code = l.countrycode
WHERE l.language = 'Javanese';

-- 4. The names of all of the countries in Africa that speak French as an official language
-- (5 row)
SELECT co.name
FROM country AS co
INNER JOIN countrylanguage AS l
ON co.code = l.countrycode
WHERE l.language = 'French' AND l.isofficial = true AND co.continent = 'Africa';

-- 5. The average city population of cities in Europe
-- (average city population in Europe: 287,684)
SELECT round(AVG(c.population), 2) AS avg_population
FROM city AS c
INNER JOIN country AS co
ON c.countrycode = co.code
WHERE co.continent = 'Europe';

-- 6. The average city population of cities in Asia
-- (average city population in Asia: 395,019)
SELECT round(AVG(c.population), 2) AS avg_population
FROM city AS c
INNER JOIN country AS co
ON c.countrycode = co.code
WHERE co.continent = 'Asia';

-- 7. The number of cities in countries where English is an official language
-- (number of cities where English is official language: 523)
SELECT COUNT(*)
FROM city AS c
INNER JOIN country AS co
ON c.countrycode = co.code
INNER JOIN countrylanguage AS l
ON co.code = l.countrycode
WHERE l.language = 'English' AND l.isofficial = true;

-- 8. The average population of cities in countries where the official language is English
-- (average population of cities where English is official language: 285,809)
SELECT round(AVG(c.population), 2) AS avg_population_english_speaking_cities
FROM city AS c
INNER JOIN country AS co
ON c.countrycode = co.code
INNER JOIN countrylanguage AS l
ON co.code = l.countrycode
WHERE l.language = 'English' AND l.isofficial = true;

-- 9. The names of all of the continents and the population of the continent’s largest city
-- (6 rows, largest population for North America: 8,591,309)
SELECT co.continent, MAX(c.population)
FROM country AS co
INNER JOIN city AS c
ON c.countrycode = co.code
GROUP BY co.continent;

-- 10. The names of all of the cities in South America that have a population of more than 1 million people and the official language of each city’s country
-- (29 rows)
SELECT c.name, l.language
FROM city AS c
INNER JOIN country AS co
ON c.countrycode = co.code
INNER JOIN countrylanguage AS l
ON co.code = l.countrycode
WHERE c.population > 1000000 AND co.continent = 'South America' AND l.isofficial = true;

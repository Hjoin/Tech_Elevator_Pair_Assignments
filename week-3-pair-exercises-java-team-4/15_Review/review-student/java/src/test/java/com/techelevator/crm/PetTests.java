package com.techelevator.crm;


import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
    public class PetTests {
        @Test
        public void list_vaccinations_returns_correct_value() {
            Pet sut = new Pet("giant", "chipmunk");
            List<String> vacList = new ArrayList<>();
            vacList.add("Rabies");
            vacList.add("Distemper");
            vacList.add("Parvo");
            String vacString = sut.listVaccinations(vacList);
            String expected = "Rabies, Distemper, Parvo";
            Assert.assertEquals(expected, vacString);
    }
        @Test
        public void setName_and_getName_test() {
            Pet sut = new Pet("giant", "chipmunk");
            sut.setName("testy");
            Assert.assertEquals("testy", sut.getName());
    }
        @Test
        public void setSpecies_and_getSpecies_test() {
            Pet sut = new Pet("chunky", "cat");
            sut.setSpecies("acular");
            Assert.assertEquals("acular", sut.getSpecies());
        }
        @Test
        public void setVaccinations_and_getVaccinations_test() {
            Pet sut = new Pet("new", "puppy");
            List<String> vacList = new ArrayList<>();
            vacList.add("check");
            sut.setVaccinations(vacList);
            List<String> expected = new ArrayList<>();
            expected.add("check");
            Assert.assertEquals(expected, sut.getVaccinations());
    }
}

package com.techelevator.crm;

import java.util.List;
import java.util.ArrayList;

public class Pet {

    private String name;
    private String species;
    private List<String> vaccinations;

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setVaccinations(List<String> vaccinations) {
        this.vaccinations = vaccinations;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public List<String> getVaccinations() {
        return vaccinations;
    }

    public Pet(String name, String species) {
        this.name = name;
        this.species = species;
        vaccinations = new ArrayList<>();
    }

    public String listVaccinations(List<String> vaccinations) {
        String result = "";
        for (int i = 0; i < vaccinations.size() - 1; i++) {
            result += vaccinations.get(i) + ", ";
        }
        return result + vaccinations.get(vaccinations.size() - 1);
    }
}

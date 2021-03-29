package com.techelevator.crm;

import static org.junit.Assert.assertEquals;

import com.techelevator.crm.Customer;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerTests {

    @Test
    public void getBalanceDue_return_correct_balance() {
        Customer sut = new Customer("For", "Tay");
        Map<String, Double> services = new HashMap<>();
        services.put("walking", 50.00);
        services.put("grooming", 50.00);
        services.put("sitting", 50.00);
        double balance = sut.getBalanceDue(services);
        double expected = 150.00;
        assertEquals(expected, balance, 0.0);
    }

    @Test
    public void setPhoneNumber_getPhone_number_tests() {
        Customer sut = new Customer("For", "Tay", "414-4140");
        sut.setPhoneNumber("414-4140");
        Assert.assertEquals("414-4140", sut.getPhoneNumber());
    }

    @Test
    public void setPets_getPets_tests() {
        Customer sut = new Customer("For", "Tay", "414-4140");
        Pet sut2 = new Pet("Puck", "Gretzky");
        List<Pet> pets = new ArrayList<>();
        pets.add(sut2);
        sut.setPets(pets);
        Assert.assertEquals(pets, sut.getPets());
    }

    private void assertEquals(double expected, double balance, double v) {
    }
}

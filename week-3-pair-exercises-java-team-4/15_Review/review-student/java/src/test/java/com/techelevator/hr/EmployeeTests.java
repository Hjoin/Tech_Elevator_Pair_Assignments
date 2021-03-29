package com.techelevator.hr;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class EmployeeTests {

    @Test
    public void getFullNameReturnsCorrectFormat() {
        Employee sut = new Employee("Pablo", "Pancake");

        String fullName = sut.getFullName();

        assertEquals("The employee full name is not in the correct format.", "Pancake, Pablo", fullName);
    }

    @Test
    public void raiseSalaryTest_Positive() {
        Employee sut = new Employee("Lost", "Mymind");
        sut.setSalary(100);

        sut.raiseSalary(5);

        assertEquals("The employee raise of 5% was not computed correctly.",sut.getSalary(), 105, 0.0);
    }

    @Test
    public void raiseSalaryTest_Negative() {
        Employee sut = new Employee("Stop", "Shop");
        sut.setSalary(100);
        sut.raiseSalary(-10); //"raise" by negative 10%

        assertEquals("Salary should remain the same when raise percentage is negative.",100, sut.getSalary(),0.0);
    }

    @Test
    public void getBalanceDue_return_correct_balance() {
        Employee sut = new Employee("LetMe", "CheckYourTest");
        Map<String, Double> services = new HashMap<>();
        services.put("walking", 50.00);
        services.put("grooming", 50.00);
        services.put("sitting", 50.00);
        double balance = sut.getBalanceDue(services);
        double expected = 125.00;
        assertEquals(expected, balance, 0.0);
    }
}

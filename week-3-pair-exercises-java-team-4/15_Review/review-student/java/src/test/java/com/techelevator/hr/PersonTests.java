package com.techelevator.hr;

import com.techelevator.Person;
import org.junit.Assert;
import org.junit.Test;

public class PersonTests {

    @Test
    public void fullNameReturnsFirstAndLastName() {
        Person sut = new Person("Test","Testerson");
        Assert.assertEquals("The full name returned from person is not in the correct format.",
                "Test Testerson",
                sut.getFullName());
    }
}

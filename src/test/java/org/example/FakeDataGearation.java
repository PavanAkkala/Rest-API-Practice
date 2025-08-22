package org.example;

import com.github.javafaker.Faker;
import org.junit.Test;

public class FakeDataGearation {

    @Test
    public void testGenerateDummyData() {

            Faker faker = new Faker();

            String fullName = faker.name().fullName();
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();

            String username = faker.name().username();
            String password = faker.internet().password();
            String phoneNo = faker.phoneNumber().cellPhone();
            String email = faker.internet().safeEmailAddress();

            System.out.println("Full Name: " + fullName);
            System.out.println("First Name: " + firstName);
            System.out.println("Last Name: " + lastName);
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
            System.out.println("Phone No: " + phoneNo);
            System.out.println("Email: " + email);
        }
    }

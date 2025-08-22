package org.example;

public class Pojo_postRequest {

    String name;
    String email;
    String gender;
    String status;
    String job;

    public String getEmail() {
        return email;
    }

    public void setName(String name) { //setter method will assign value to the vaiaable getter method will get that value from the varaible
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGender() {
        return gender;
    }

    public String getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }



}

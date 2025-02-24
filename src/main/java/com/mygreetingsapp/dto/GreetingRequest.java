package com.mygreetingsapp.dto;

public class GreetingRequest {
    private String firstName;
    private String lastName;

    // Constructors
    public GreetingRequest() {}

    public GreetingRequest(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getter method to get the firstName
    public String getFirstName() {
        return firstName;
    }

    // Setter Method to set the firstName
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter method to get the  LastName
    public String getLastName() {
        return lastName;
    }

    //Setter method to set the LastName
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

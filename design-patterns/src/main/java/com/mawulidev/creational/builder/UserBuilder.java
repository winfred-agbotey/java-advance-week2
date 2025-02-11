package com.mawulidev.creational.builder;


public class UserBuilder {
    // Builder fields; package-private so User can access them
    String firstName;
    String lastName;
    String phoneNumber;
    int age;
    String email;

    public UserBuilder firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserBuilder age(int age) {
        this.age = age;
        return this;
    }

    public UserBuilder email(String email) {
        this.email = email;
        return this;
    }
    public UserBuilder phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public User build() {
        // Optionally, you can add validation logic here before creating the User.
        return new User(this);
    }
}

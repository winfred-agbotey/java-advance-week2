package com.mawulidev.creational.builder;

public class Main {
    public static void main(String[] args) {
        User user = new UserBuilder()
                .firstName("John")
                .lastName("Doe")
                .age(30)
                .phoneNumber("0554704302")
                .email("john.doe@example.com")
                .build();
        System.out.println(user);

    }
}

package com.mawulidev.behavioral.template.example2;

public abstract class DataValidator {
    public final boolean validate(String data) {
        if (isValidFormat(data)) {
            System.out.println(data + " is valid.");
            return true;
        } else {
            System.out.println(data + " is invalid.");
            return false;
        }
    }

    protected abstract boolean isValidFormat(String data);
}

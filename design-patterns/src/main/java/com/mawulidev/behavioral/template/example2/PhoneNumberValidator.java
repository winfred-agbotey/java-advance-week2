package com.mawulidev.behavioral.template.example2;

import java.util.regex.Pattern;

public class PhoneNumberValidator extends DataValidator{
    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\+?[0-9]{10,15}$");

    @Override
    protected boolean isValidFormat(String data) {
        return PHONE_PATTERN.matcher(data).matches();
    }
}

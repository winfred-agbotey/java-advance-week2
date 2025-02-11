package com.mawulidev.behavioral.template.example2;

import java.util.regex.Pattern;

public class EmailValidator extends DataValidator{
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

    @Override
    protected boolean isValidFormat(String data) {
        return EMAIL_PATTERN.matcher(data).matches();
    }
}

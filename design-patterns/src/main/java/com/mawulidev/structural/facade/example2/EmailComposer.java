package com.mawulidev.structural.facade.example2;

public class EmailComposer {
    public EmailMessage compose(String to, String subject, String body) {
        System.out.println("Composing email to " + to);
        return new EmailMessage(to, subject, body);
    }
}

package com.mawulidev.structural.facade.example2;

public class EmailLogger {
    public void log(EmailMessage email) {
        System.out.println("Email sent to: " + email.getTo() +
                " with subject: " + email.getSubject());
    }
}

package com.mawulidev.structural.facade.example2;

public class EmailSender {
    public void send(EmailMessage email) {
        System.out.println("Sending email to " + email.getTo());
    }
}

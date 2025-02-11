package com.mawulidev.structural.facade.example2;

public class EmailFacade {
    private final EmailComposer composer;
    private final EmailSender sender;
    private final EmailLogger logger;

    public EmailFacade() {
        composer = new EmailComposer();
        sender = new EmailSender();
        logger = new EmailLogger();
    }

    public void sendEmail(String to, String subject, String body) {
        EmailMessage email = composer.compose(to, subject, body);
        sender.send(email);
        logger.log(email);
    }
}

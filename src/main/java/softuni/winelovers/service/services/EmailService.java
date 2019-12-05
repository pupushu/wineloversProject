package softuni.winelovers.service.services;

import javax.mail.MessagingException;

public interface EmailService {
    void sendSimpleMsg(String to, String subject, String text) throws MessagingException;
}

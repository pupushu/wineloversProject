package softuni.winelovers.service.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import softuni.winelovers.common.Constants;
import softuni.winelovers.service.services.EmailService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class EmailServiceImpl implements EmailService {
    public final JavaMailSender getJavaMailSender;


    @Autowired
    public EmailServiceImpl(JavaMailSender getJavaMailSender) {
        this.getJavaMailSender = getJavaMailSender;
    }

    @Override
    public void sendSimpleMsg(String to, String subject, String text) throws MessagingException {
        MimeMessage message = getJavaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(String.format(Constants.REGISTER_EMAIL_TEXT, text, text));
        message.setContent(String.format(Constants.REGISTER_EMAIL_TEXT, text, text), "text/html");
        getJavaMailSender.send(message);
    }
}

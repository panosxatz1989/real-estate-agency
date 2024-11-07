package demo.pxportfolio.realestateagency.notification.email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
@RequiredArgsConstructor
public class EmailService {

    //private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;

    @Async
    public void sendEmail(String receiver, String subject, String body) {

        // TODO - Before sending mail, perform validations here
//
//        Context context = new Context();
//        context.setVariable("subject", subject);
//        context.setVariable("body", body);
//
//        String htmlContent = templateEngine.process("email.html", context);
//
//        MimeMessage mimeMessage = mailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
//
//        try {
//            helper.setFrom("Sweet Home - Real Estate Agency");
//            helper.setTo(receiver);
//            helper.setSubject(subject);
//            helper.setText(htmlContent, true);
//        } catch (MessagingException ex) {
//
//        }
//
//        mailSender.send(mimeMessage);
    }
}

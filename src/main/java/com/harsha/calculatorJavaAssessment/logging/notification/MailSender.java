package com.harsha.calculatorJavaAssessment.logging.notification;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailSender implements NotificationsSender {
    @Override
    public void sendNotification(Notification notification) {

        Properties properties = new Properties();
        configureProperties(properties);

        String username = "8ffba986c462f8";
        String password = "9db1a7eb0c73e5";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(notification.getFromAddress()));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(notification.getToAddress()));
            message.setSubject(notification.getSubject());

            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(notification.getMessage());

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(notification.getAttachment());
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(notification.getAttachment().getName());
            multipart.addBodyPart(messageBodyPart);

            message.setContent(multipart);
            Transport.send(message);
            System.out.println("Sent message successfully....");

        } catch (MessagingException e) {
            System.out.println("Message sent failed.");
            e.printStackTrace();
        }
    }

    public void configureProperties(Properties properties) {

        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.mailtrap.io");
        properties.put("mail.smtp.port", "2525");
        properties.put("mail.smtp.ssl.trust", "smtp.mailtrap.io");
    }
}

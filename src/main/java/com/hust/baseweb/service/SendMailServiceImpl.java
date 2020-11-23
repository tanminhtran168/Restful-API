package com.hust.baseweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.List;


@Service
public class SendMailServiceImpl implements SendMailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String emailSender;

    @Override
    public boolean sendMail (List<String> userMails, String header, String content) {
        try {
            SimpleMailMessage mail = new SimpleMailMessage();
            for (String userMail: userMails) {
                mail.setTo(userMail);
                mail.setFrom(emailSender);
                mail.setSubject(header);
                mail.setText(content);
                javaMailSender.send(mail);
            }
        } catch (MailException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean sendHtmlMail(String userMail, String header, String content) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mail = new MimeMessageHelper(mimeMessage, "utf-8");
            mail.setTo(userMail);
            mail.setFrom(emailSender);
            mail.setSubject(header);
            mail.setCc("tanminhtran168@gmail.com");
            mail.setText(content, true);
            javaMailSender.send(mimeMessage);
            return true;
        } catch (MailException | MessagingException e) {
            e.printStackTrace();
        }
        return false;
    }

}

package com.ms.email.domain.services;

import com.ms.email.DTO.EmailDTO;
import com.ms.email.assembler.EmailAssembler;
import com.ms.email.domain.entities.Email;
import com.ms.email.domain.enums.StatusEmail;
import com.ms.email.domain.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Autowired
    EmailRepository emailRepository;
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    EmailAssembler emailAssembler;

    public EmailDTO sendEmail(Email email) {
        email.setSendDateEmail(LocalDateTime.now());
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(email.getEmailFrom());
            message.setTo(email.getEmailTo());
            message.setSubject(email.getSubject());
            message.setText(email.getEmailBody());
            javaMailSender.send(message);
            email.setStatusEmail(StatusEmail.SENT);
        } catch (MailException me){
            email.setStatusEmail(StatusEmail.ERROR);
        } finally {
            return emailAssembler.toModel(emailRepository.save(email));
        }
    }
}

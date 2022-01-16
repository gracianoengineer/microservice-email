package com.ms.email.consumers;

import com.ms.email.assembler.EmailAssembler;
import com.ms.email.domain.entities.Email;
import com.ms.email.domain.services.EmailService;
import com.ms.email.form.EmailForm;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
    EmailService emailService;

    @Autowired
    EmailAssembler emailAssembler;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void receive(@Payload EmailForm emailForm){
        Email email = emailAssembler.toEntity(emailForm);
        emailService.sendEmail(email);
        System.out.println("Email status: " + email.getStatusEmail().toString());
    }
}

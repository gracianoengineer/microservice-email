package com.ms.email.controllers;

import com.ms.email.DTO.EmailDTO;
import com.ms.email.assembler.EmailAssembler;
import com.ms.email.domain.entities.Email;
import com.ms.email.domain.services.EmailService;
import com.ms.email.form.EmailForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class EmailController {

    @Autowired
    EmailService emailService;

    @Autowired
    EmailAssembler emailAssembler;

    @PostMapping("/sending-email")
    public ResponseEntity<?> sendingEmail(@RequestBody @Valid EmailForm emailForm){
        Email email = emailAssembler.toEntity(emailForm);
        EmailDTO emailDTO = emailService.sendEmail(email);
        return new ResponseEntity<>(emailDTO, HttpStatus.CREATED);
    }
}

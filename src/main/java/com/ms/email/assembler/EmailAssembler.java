package com.ms.email.assembler;

import com.ms.email.DTO.EmailDTO;
import com.ms.email.domain.entities.Email;
import com.ms.email.form.EmailForm;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class EmailAssembler {

    private ModelMapper modelMapper;

    public Email toEntity(EmailForm emailForm){
        return modelMapper.map(emailForm, Email.class);
    }

    public EmailDTO toModel(Email email){
        return modelMapper.map(email, EmailDTO.class);
    }
}

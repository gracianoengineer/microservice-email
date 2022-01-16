package com.ms.email.DTO;

import com.ms.email.domain.enums.StatusEmail;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class EmailDTO {

    private UUID emailId;
    private String ownerRef;
    private String emailFrom;
    private String emailTo;
    private String subject;
    private String emailBody;
    private LocalDateTime sendDateEmail;
    private StatusEmail statusEmail;
}

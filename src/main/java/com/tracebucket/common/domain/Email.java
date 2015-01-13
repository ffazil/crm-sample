package com.tracebucket.common.domain;

import com.tracebucket.common.dictionary.EmailType;
import com.tracebucket.infrastructure.ddd.annotation.ValueObject;

import javax.persistence.*;

@ValueObject
@Embeddable
public class Email {

    @Column(name = "EMAIL")
    @Basic(fetch = FetchType.EAGER)
    private String email;

    @Column(name = "EMAIL_TYPE", nullable = false, columnDefinition = "ENUM('PERSONAL', 'BUSINESS') default 'BUSINESS'")
    @Enumerated(EnumType.STRING)
    private EmailType emailType;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EmailType getEmailType() {
        return emailType;
    }

    public void setEmailType(EmailType emailType) {
        this.emailType = emailType;
    }
}

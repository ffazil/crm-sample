package com.tracebucket.common.domain;

import com.tracebucket.common.dictionary.EmailType;
import com.tracebucket.infrastructure.ddd.annotation.ValueObject;
import com.tracebucket.infrastructure.ddd.domain.BaseValueObject;

import javax.persistence.*;

@ValueObject
@Embeddable
public class Email extends BaseValueObject {

    @Column(name = "EMAIL")
    @Basic(fetch = FetchType.EAGER)
    private String email;

    @Column(name = "EMAIL_TYPE", nullable = false, columnDefinition = "ENUM('PERSONAL', 'BUSINESS') default 'BUSINESS'")
    @Enumerated(EnumType.STRING)
    private EmailType emailType;

    @Column(name = "DEFAULT_EMAIL", nullable = false, columnDefinition = "boolean default true")
    @Basic(fetch = FetchType.EAGER)
    private boolean defaultEmail;

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

    public boolean isDefaultEmail() {
        return defaultEmail;
    }

    public void setDefaultEmail(boolean defaultEmail) {
        this.defaultEmail = defaultEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Email)) return false;

        Email email1 = (Email) o;

        if (!email.equals(email1.email)) return false;
        if (emailType != email1.emailType) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = email.hashCode();
        result = 31 * result + (emailType != null ? emailType.hashCode() : 0);
        return result;
    }
}

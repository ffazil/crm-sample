package com.tracebucket.crm.test.builder;

import com.tracebucket.common.dictionary.EmailType;
import com.tracebucket.common.domain.Email;

/**
 * Created by sadath on 25-Nov-14.
 */
public class EmailBuilder {
    private String email;
    private EmailType emailType;

    private EmailBuilder(){ }

    public static EmailBuilder anEmailBuilder(){
        return new EmailBuilder();
    }

    public EmailBuilder withEmail(String email){
        this.email = email;
        return this;
    }

    public EmailBuilder withEmailType(EmailType emailType){
        this.emailType = emailType;
        return this;
    }

    public Email build(){
        Email email = new Email();
        email.setEmail(this.email);
        email.setEmailType(emailType);
        return email;
    }

}

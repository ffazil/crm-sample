package com.tracebucket.crm.test.fixture;

import com.tracebucket.common.dictionary.EmailType;
import com.tracebucket.common.domain.Email;
import com.tracebucket.crm.test.builder.EmailBuilder;

import java.util.UUID;

/**
 * Created by sadath on 25-Nov-14.
 */
public class EmailFixture {
    public static Email standardEmail() {
        Email email = EmailBuilder.anEmailBuilder()
                .withEmail(UUID.randomUUID().toString())
                .withEmailType(EmailType.BUSINESS)
                .build();
        return email;
    }
}

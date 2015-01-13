package com.tracebucket.crm.test.fixture;

import com.tracebucket.common.dictionary.PhoneType;
import com.tracebucket.common.domain.Phone;
import com.tracebucket.crm.test.builder.PhoneBuilder;

import java.util.Date;

/**
 * Created by sadath on 25-Nov-14.
 */
public class PhoneFixture {
    public static Phone standardPhone() {
        Phone email = PhoneBuilder.aPhoneBuilder()
                .withExtension(new Long(new Date().getTime()).intValue())
                .withNumber(new Date().getTime())
                .withPhoneType(PhoneType.HOME)
                .build();
        return email;
    }
}

package com.tracebucket.crm.test.builder;

import com.tracebucket.common.dictionary.PhoneType;
import com.tracebucket.common.domain.Phone;

/**
 * Created by sadath on 25-Nov-14.
 */
public class PhoneBuilder {
    private Long number;
    private Integer extension;
    private PhoneType phoneType;

    private PhoneBuilder(){ }

    public static PhoneBuilder aPhoneBuilder(){
        return new PhoneBuilder();
    }

    public PhoneBuilder withNumber(Long number){
        this.number = number;
        return this;
    }

    public PhoneBuilder withExtension(Integer extension){
        this.extension = extension;
        return this;
    }

    public PhoneBuilder withPhoneType(PhoneType phoneType){
        this.phoneType = phoneType;
        return this;
    }

    public Phone build() {
        Phone phone = new Phone();
        phone.setNumber(number);
        phone.setExtension(extension);
        phone.setPhoneType(phoneType);
        return phone;
    }
}

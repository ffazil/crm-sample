package com.tracebucket.common.domain;

import com.tracebucket.common.dictionary.PhoneType;
import com.tracebucket.infrastructure.ddd.annotation.ValueObject;

import javax.persistence.*;

@ValueObject
@Embeddable
public class Phone {

    @Column(name = "NUMBER")
    @Basic(fetch = FetchType.EAGER)
    private Long number;

    @Column(name = "EXTENSION")
    @Basic(fetch = FetchType.EAGER)
    private Integer extension;

    @Column(name = "PHONE_TYPE", nullable = false, columnDefinition = "ENUM('MOBILE', 'WORK', 'HOME') default 'WORK'")
    @Enumerated(EnumType.STRING)
    private PhoneType phoneType;

    public Phone(){

    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Integer getExtension() {
        return extension;
    }

    public void setExtension(Integer extension) {
        this.extension = extension;
    }

    public PhoneType getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Phone)) return false;

        Phone phone = (Phone) o;

        if (extension != null ? !extension.equals(phone.extension) : phone.extension != null) return false;
        if (!number.equals(phone.number)) return false;
        if (phoneType != phone.phoneType) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = number.hashCode();
        result = 31 * result + (extension != null ? extension.hashCode() : 0);
        result = 31 * result + (phoneType != null ? phoneType.hashCode() : 0);
        return result;
    }
}

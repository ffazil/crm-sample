package com.tracebucket.partner;

import com.mmpsoftware.aurora.common.dictionary.Gender;
import com.mmpsoftware.aurora.common.dictionary.Salutation;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by sadath on 05-Aug-14.
 */
@Entity
@Table(name = "CUSTOMER")
@PrimaryKeyJoinColumn(name="PARTNER_ROLE__ID")
@DiscriminatorValue(value = "CUSTOMER")
public class Customer extends PartnerRole {
    private static final String simpleName = "Customer";

    @Column(name = "INITIAL")
    @Basic(fetch = FetchType.EAGER)
    private String initial;

    @Column(name = "SALUTATION")
    @Basic(fetch = FetchType.EAGER)
    private Salutation salutation;

    @Column(name = "FIRST_NAME")
    @Basic(fetch = FetchType.EAGER)
    private String firstName;

    @Column(name = "MIDDLE_NAME")
    @Basic(fetch = FetchType.EAGER)
    private String middleName;

    @Column(name = "LAST_NAME")
    @Basic(fetch = FetchType.EAGER)
    private String lastName;

    @Column(name = "DATE_OF_BIRTH")
    @Basic(fetch = FetchType.EAGER)
    private Date birthDay;

    @Column(name = "GENDER")
    @Basic(fetch = FetchType.EAGER)
    private Gender gender;

    @Column(name = "EMAIL")
    @Basic(fetch = FetchType.EAGER)
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String simpleName() {
        return simpleName;
    }
}

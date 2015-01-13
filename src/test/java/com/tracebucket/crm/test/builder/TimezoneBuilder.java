package com.tracebucket.crm.test.builder;

import com.tracebucket.common.dictionary.TimezoneType;
import com.tracebucket.common.domain.Timezone;

/**
 * Created by sadath on 21-Nov-14.
 */
public class TimezoneBuilder {
    private String name;
    private String abbreviation;
    private Integer utcOffset;
    private String image;
    private TimezoneType timezoneType;

    private TimezoneBuilder(){ }

    public static TimezoneBuilder aTimezoneBuilder(){
        return new TimezoneBuilder();
    }

    public TimezoneBuilder withName(String name){
        this.name = name;
        return this;
    }

    public TimezoneBuilder withAbbreviation(String abbreviation){
        this.abbreviation = abbreviation;
        return this;
    }

    public TimezoneBuilder withUtcOffset(Integer utcOffset){
        this.utcOffset = utcOffset;
        return this;
    }

    public TimezoneBuilder withImage(String image){
        this.image = image;
        return this;
    }

    public TimezoneBuilder withTimezoneType(TimezoneType timezoneType){
        this.timezoneType = timezoneType;
        return this;
    }

    public Timezone build(){
        Timezone timezone = new Timezone();
        timezone.setName(name);
        timezone.setAbbreviation(abbreviation);
        timezone.setUtcOffset(utcOffset);
        timezone.setImage(image);
        timezone.setTimezoneType(timezoneType);
        return timezone;
    }

}

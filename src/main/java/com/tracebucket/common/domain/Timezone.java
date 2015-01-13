package com.tracebucket.common.domain;

import com.tracebucket.common.dictionary.TimezoneType;
import com.tracebucket.infrastructure.ddd.domain.BaseEntity;

import javax.persistence.*;

/**
 * Created by ffl on 20-11-2014.
 */
@Entity
@Table(name = "TIMEZONE")
public class Timezone extends BaseEntity {

    @Column(name = "NAME", nullable = false)
    @Basic(fetch = FetchType.EAGER)
    private String name;

    @Column(name = "ABBREVIATION")
    @Basic(fetch = FetchType.EAGER)
    private String abbreviation;

    @Column(name = "UTC_OFFSET")
    @Basic(fetch = FetchType.EAGER)
    private Integer utcOffset;

    @Column(name = "IMAGE")
    @Basic(fetch = FetchType.EAGER)
    private String image;

    @Column(name = "TIMEZONE_TYPE", nullable = false, columnDefinition = "ENUM('DEFAULT','OPTIONAL', 'OPTION_1', 'OPTION_2') default 'DEFAULT'")
    @Enumerated(EnumType.STRING)
    private TimezoneType timezoneType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public Integer getUtcOffset() {
        return utcOffset;
    }

    public void setUtcOffset(Integer utcOffset) {
        this.utcOffset = utcOffset;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public TimezoneType getTimezoneType() {
        return timezoneType;
    }

    public void setTimezoneType(TimezoneType timezoneType) {
        this.timezoneType = timezoneType;
    }
}

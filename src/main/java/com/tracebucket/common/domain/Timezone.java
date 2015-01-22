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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Timezone)) return false;

        Timezone timezone = (Timezone) o;

        if (abbreviation != null ? !abbreviation.equals(timezone.abbreviation) : timezone.abbreviation != null)
            return false;
        if (image != null ? !image.equals(timezone.image) : timezone.image != null) return false;
        if (!name.equals(timezone.name)) return false;
        if (timezoneType != timezone.timezoneType) return false;
        if (utcOffset != null ? !utcOffset.equals(timezone.utcOffset) : timezone.utcOffset != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (abbreviation != null ? abbreviation.hashCode() : 0);
        result = 31 * result + (utcOffset != null ? utcOffset.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (timezoneType != null ? timezoneType.hashCode() : 0);
        return result;
    }
}

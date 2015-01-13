package com.tracebucket.crm.test.fixture;

import com.tracebucket.common.dictionary.TimezoneType;
import com.tracebucket.common.domain.Timezone;
import com.tracebucket.crm.test.builder.TimezoneBuilder;

import java.util.Date;

/**
 * Created by sadath on 24-Nov-14.
 */
public class TimezoneFixture {
    public static Timezone standardTimezone() {
        Timezone timezone = TimezoneBuilder.aTimezoneBuilder()
                .withName("GMT " + new Date().getTime())
                .withImage("image")
                .withAbbreviation("GMT_ABBR")
                .withUtcOffset(111111)
                .withTimezoneType(TimezoneType.DEFAULT)
                .build();
        return timezone;
    }

    public static Timezone standardTimezone2() {
        Timezone timezone = TimezoneBuilder.aTimezoneBuilder()
                .withName("UTC " + new Date().getTime())
                .withImage("image")
                .withAbbreviation("UTC_ABBR")
                .withUtcOffset(22222222)
                .withTimezoneType(TimezoneType.OPTION_1)
                .build();
        return timezone;
    }
}

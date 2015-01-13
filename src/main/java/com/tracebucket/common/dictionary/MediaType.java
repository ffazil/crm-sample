package com.tracebucket.common.dictionary;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Created by ffl on 11-04-2014.
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum MediaType {
    IMAGE("Image","IMAGE"),
    VIDEO("Video","VIDEO");

    private final String mediaType;
    private final String abbreviation;

    MediaType(String mediaType, String abbreviation){
        this.mediaType = mediaType;
        this.abbreviation = abbreviation;
    }

    public String getMediaType(){
        return mediaType;
    }

    public String getAbbreviation(){
        return abbreviation;
    }
}

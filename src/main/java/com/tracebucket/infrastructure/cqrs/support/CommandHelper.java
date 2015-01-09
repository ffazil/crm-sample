package com.tracebucket.infrastructure.cqrs.support;

import org.springframework.stereotype.Component;

/**
 * Created by ffl on 16-09-2014.
 */
@Component
public class CommandHelper {
    private static final String prefix = "Command|";

    public static String command(String command){
        return new StringBuilder()
                .append(prefix)
                .append(command)
                .toString();
    }


}

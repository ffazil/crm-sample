package com.tracebucket.infrastructure.cqrs.support;

import org.springframework.stereotype.Component;

/**
 * Created by ffl on 11-02-2015.
 */
public class CommandWrapper {
    private Command command;

    public void setCommand(Command command){
        this.command = command;

    }

    public Command getCommand(){
        return this.command;
    }
}

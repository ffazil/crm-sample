package com.tracebucket.infrastructure.cqrs.support;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * Created by ffl on 11-02-2015.
 */
public class CommandWrapper {
    private Command command;
    private DeferredResult deferredResult;

    public void setCommand(Command command){
        this.command = command;

    }

    public Command getCommand(){
        return this.command;
    }

    public DeferredResult getDeferredResult() {
        return deferredResult;
    }

    public void setDeferredResult(DeferredResult deferredResult) {
        this.deferredResult = deferredResult;
    }
}

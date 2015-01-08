package com.tracebucket.infrastructure.cqrs.support;

import org.springframework.data.annotation.Id;
import reactor.event.Event;
import reactor.function.Consumer;

import java.util.Date;
import java.util.UUID;

/**
 * Created by ffl on 16-09-2014.
 */
public class Command<T> extends Event<T> {

    @Id
    private String cid;

    private Date timestamp;

    public Command(Class aClass){
        super(aClass);
    }


    public Command(Headers headers, T data) {
        super(headers, data);
        init();
    }

    public Command(Headers headers, T data, Consumer<Throwable> errorConsumer) {
        super(headers, data, errorConsumer);
        init();
    }

    public Command(T data) {
        super(data);
        init();
    }

    public static <T> Command<T> wrap(T obj) {
        return new Command<T>(obj);
    }

    private void init(){
        this.cid = UUID.randomUUID().toString();
        timestamp = new Date();

    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
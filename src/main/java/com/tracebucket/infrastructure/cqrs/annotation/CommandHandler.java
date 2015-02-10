package com.tracebucket.infrastructure.cqrs.annotation;

import reactor.spring.context.annotation.Selector;

import java.lang.annotation.*;

/**
 * Created by ffl on 09-02-2015.
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CommandHandler {
}

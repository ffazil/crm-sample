package com.tracebucket.infrastructure.cqrs.annotation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ffl on 10-02-2015.
 */
@RequestMapping
public @interface CommandMapping {
    String name() default "";
    String[] value() default {};
    RequestMethod[] method() default {};
    String[] params() default {};
    String[] headers() default {};
    String[] consumes() default {};
    String[] produces() default {};
    String commandBus() default "";
}

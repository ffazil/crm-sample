package com.tracebucket.infrastructure.ddd.annotation;

import java.lang.annotation.*;

/**
 * Created by ffl on 29-01-2015.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
@Documented
public @interface DomainMethod {
    public String event() default "";
}

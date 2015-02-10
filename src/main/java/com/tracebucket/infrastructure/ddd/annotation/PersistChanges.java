package com.tracebucket.infrastructure.ddd.annotation;

import com.tracebucket.infrastructure.ddd.repository.jpa.BaseAggregateRepository;

import java.lang.annotation.*;

/**
 * Created by ffl on 09-02-2015.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
@Documented
public @interface PersistChanges {
    public String repository() default "";
}

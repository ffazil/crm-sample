package com.tracebucket.infrastructure.cqrs.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created by ffl on 07-01-2015.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Component
public @interface ApplicationService {
}

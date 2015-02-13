package com.tracebucket.infrastructure.cqrs.annotation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.spring.context.annotation.Consumer;

import java.lang.annotation.*;

/**
 * Created by ffl on 07-01-2015.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Consumer
public @interface ApplicationService {
}

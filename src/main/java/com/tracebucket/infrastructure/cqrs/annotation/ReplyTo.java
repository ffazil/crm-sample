package com.tracebucket.infrastructure.cqrs.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ReplyTo {

	/**
	 * An expression which evaluates to a key to which is sent the method return value.
	 * If empty, consumer will try to use {@link reactor.event.Event#getReplyTo()} header.
	 *
	 * @return The expression.
	 */
	String value() default "";

}

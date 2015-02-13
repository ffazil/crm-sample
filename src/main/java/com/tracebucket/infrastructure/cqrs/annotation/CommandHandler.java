package com.tracebucket.infrastructure.cqrs.annotation;

import reactor.spring.context.annotation.Selector;
import reactor.spring.context.annotation.SelectorType;

import java.lang.annotation.*;

/**
 * Created by ffl on 09-02-2015.
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface CommandHandler {
    /**
     * An expression that evaluates to a {@link reactor.event.selector.Selector} to register
     * this handler with the {@link
     * reactor.core.Reactor}.
     * If empty, consumer will be subscribed on the global reactor selector
     * {@link reactor.core.Reactor#on(reactor.event.selector.Selector selector, reactor.function.Consumer)}
     *
     * @return An expression to be evaluated.
     */
    String value() default "";

    /**
     * An expression that evaluates to the {@link reactor.core.Reactor} on which to place this handler.
     *
     * @return An expression to be evaluated.
     */
    String reactor() default "reactor";

    /**
     * The type of {@link reactor.event.selector.Selector} to register.
     *
     * @return The type of the {@link reactor.event.selector.Selector}.
     */
    SelectorType type() default SelectorType.OBJECT;
}

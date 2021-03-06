package com.tracebucket.infrastructure.context;

import org.springframework.context.annotation.Import;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(TronBeanDefinitionRegistrar.class)
public @interface EnableTron {

	/**
	 * Name of the profile to use as the default.
	 *
	 * @return default profile name
	 */
	String value() default "";

	/**
	 * The bean name of {@link reactor.function.Supplier} that can provide an instance (or instances) of {@link reactor
	 * .core.Environment} to be registered in the {@link org.springframework.context.ApplicationContext}.
	 *
	 * @return bean name of {@link reactor.core.Environment} {@link reactor.function.Supplier}
	 */
	String environmentSupplier() default "";

}

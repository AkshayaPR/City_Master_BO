package kgfsl.stalk.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.METHOD)
@Constraint(validatedBy = ExchangeCodeValidator.class)
public @interface ExchangeCode {

	String message() default "No such Exchange exists with given code!";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}

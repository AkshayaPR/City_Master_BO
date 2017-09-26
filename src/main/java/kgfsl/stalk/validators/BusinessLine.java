package kgfsl.stalk.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.METHOD)
@Constraint(validatedBy = BusinessLineValidator.class)
public @interface BusinessLine {

	String message() default "No such Business Line exists with given code!";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}

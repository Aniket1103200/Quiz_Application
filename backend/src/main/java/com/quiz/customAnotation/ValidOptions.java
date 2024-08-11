package com.quiz.customAnotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = OptionsValidator.class)
public @interface ValidOptions {
    String message() default "All 4 options must be provided and non-empty.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

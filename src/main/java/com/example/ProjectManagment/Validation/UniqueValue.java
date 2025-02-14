package com.example.ProjectManagment.Validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueValidator.class)
public @interface UniqueValue {

    String message() default "The email entered is a duplicate.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

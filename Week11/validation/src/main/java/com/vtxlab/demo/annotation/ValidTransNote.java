package com.vtxlab.demo.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.vtxlab.demo.annotation.validator.TransNoteValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

//@NotBlank
//@Size(min = 10, max = 10)
//@Pattern("{$[]}")
@Target({ ElementType.FIELD })
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TransNoteValidator.class)
public @interface ValidTransNote {
  String message() default "Transaction Note is not valid";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}

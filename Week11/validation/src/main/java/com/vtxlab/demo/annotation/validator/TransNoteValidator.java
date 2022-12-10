package com.vtxlab.demo.annotation.validator;

import com.vtxlab.demo.annotation.ValidTransNote;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TransNoteValidator
    implements ConstraintValidator<ValidTransNote, String> {

  public boolean isValid(String transNote, ConstraintValidatorContext cxt) {
    if (transNote == null)
      return false;
    if (!transNote.startsWith("NOTE"))
      return false;
    if (transNote.length() != 10)
      return false;
    return true;
  }
}

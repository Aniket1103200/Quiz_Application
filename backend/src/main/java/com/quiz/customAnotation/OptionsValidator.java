package com.quiz.customAnotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class OptionsValidator implements ConstraintValidator<ValidOptions, String[]> {

    @Override
    public boolean isValid(String[] options, ConstraintValidatorContext context) {
        if (options == null || options.length != 4) {
            return false;
        }

        for (String option : options) {
            if (option == null || option.trim().isEmpty()) {
                return false;
            }
        }

        return true;
    }
}


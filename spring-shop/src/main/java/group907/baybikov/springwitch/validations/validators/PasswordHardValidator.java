package group907.baybikov.springwitch.validations.validators;

import group907.baybikov.springwitch.validations.annotations.PasswordHard;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PasswordHardValidator implements ConstraintValidator<PasswordHard, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return Pattern.matches("(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{6,}", s);
    }
}

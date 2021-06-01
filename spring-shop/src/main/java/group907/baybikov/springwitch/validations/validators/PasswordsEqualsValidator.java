package group907.baybikov.springwitch.validations.validators;

import group907.baybikov.springwitch.forms.SignUpForm;
import group907.baybikov.springwitch.validations.annotations.PasswordsEquals;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordsEqualsValidator implements ConstraintValidator<PasswordsEquals, SignUpForm> {

    @Override
    public boolean isValid(SignUpForm signUpForm, ConstraintValidatorContext constraintValidatorContext) {
        return signUpForm.getRepeatPassword().equals(signUpForm.getPassword());
    }
}

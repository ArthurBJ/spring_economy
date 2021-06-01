package group907.baybikov.springwitch.validations.annotations;

import group907.baybikov.springwitch.validations.validators.PasswordsEqualsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PasswordsEqualsValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordsEquals {
    String message() default "Пароли не совпадают";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}

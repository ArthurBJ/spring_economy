package group907.baybikov.springwitch.validations.annotations;

import group907.baybikov.springwitch.validations.validators.PasswordHardValidator;
import group907.baybikov.springwitch.validations.validators.PasswordsEqualsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PasswordHardValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordHard {
    String message() default "Пароли слишком простой";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}

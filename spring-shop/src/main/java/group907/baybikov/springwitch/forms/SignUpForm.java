package group907.baybikov.springwitch.forms;

import group907.baybikov.springwitch.validations.annotations.PasswordHard;
import group907.baybikov.springwitch.validations.annotations.PasswordsEquals;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@PasswordsEquals
public class SignUpForm {

    @NotBlank(message = "Пусто")
    private String firstname;
    @NotBlank(message = "Пусто")
    private String lastname;
    @Email(message = "Не похоже на настоящую почту")
    private String email;
    @PasswordHard
    private String password;
    @PasswordHard
    private String repeatPassword;

}

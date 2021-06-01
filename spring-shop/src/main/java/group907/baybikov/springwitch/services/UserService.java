package group907.baybikov.springwitch.services;


import group907.baybikov.springwitch.dto.UserDto;
import group907.baybikov.springwitch.forms.SignUpForm;
import group907.baybikov.springwitch.forms.UserChangeForm;

import java.util.Optional;

public interface UserService {
    Optional<UserDto> userByEmail(String email);

    boolean signUp(SignUpForm form);

    boolean confirm(String code);

    void change(UserChangeForm form);
}

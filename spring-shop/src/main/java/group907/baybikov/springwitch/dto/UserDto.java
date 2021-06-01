package group907.baybikov.springwitch.dto;

import group907.baybikov.springwitch.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private Long id;

    private String firstname;
    private String lastname;
    private String email;

    private User.Role role;
    private User.State state;

    private String image;
}

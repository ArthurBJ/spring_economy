package group907.baybikov.springwitch.forms;

import group907.baybikov.springwitch.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserChangeForm {

    private String firstname;
    private String lastname;
    private MultipartFile image;
    private UserDto user;
}

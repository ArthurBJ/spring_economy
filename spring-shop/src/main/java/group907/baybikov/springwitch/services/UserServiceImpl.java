package group907.baybikov.springwitch.services;

import group907.baybikov.springwitch.dto.UserDto;
import group907.baybikov.springwitch.forms.SignUpForm;
import group907.baybikov.springwitch.forms.UserChangeForm;
import group907.baybikov.springwitch.models.User;
import group907.baybikov.springwitch.repositories.UserRepository;
import lombok.SneakyThrows;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ExecutorService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ExecutorService executorService;

    @Autowired
    private EMailService eMailService;

    @Value("${image.path}")
    private String pathImage;

    @Override
    public Optional<UserDto> userByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(user -> modelMapper.map(user, UserDto.class));
    }

    @Override
    public boolean signUp(SignUpForm form) {
        if (userRepository.findByEmail(form.getEmail()).isPresent())
            return false;

        String confirmed = UUID.randomUUID().toString();

        User user = User.builder()
                .email(form.getEmail())
                .firstname(form.getFirstname())
                .lastname(form.getLastname())
                .password(passwordEncoder.encode(form.getPassword()))
                .confirmedCode(confirmed)
                .build();

        userRepository.save(user);

        executorService.submit(() -> {
            eMailService.sendEmail(user.getEmail(), confirmed);
        });

        return true;
    }

    @Override
    public boolean confirm(String code) {
        Optional<User> byConfirmedCode = userRepository.findByConfirmedCode(code);
        if (byConfirmedCode.isPresent()) {
            byConfirmedCode.get().setStatus(User.Status.CONFIRMED);

            userRepository.save(byConfirmedCode.get());
            return true;
        }
        return false;
    }

    @Override
    public void change(UserChangeForm form) {
        User user = userRepository.findById(form.getUser().getId())
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));

        user.setFirstname(form.getFirstname());
        user.setLastname(form.getLastname());

        if (!form.getImage().isEmpty()) {
            user.setImage(save(form.getImage(), pathImage));
        }

        userRepository.save(user);
    }

    @SneakyThrows
    public static String save(MultipartFile file, String directory) {
        String file_name = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        IOUtils.copyLarge(file.getInputStream(), new FileOutputStream(directory + File.separator + file_name));
        return file_name;
    }
}

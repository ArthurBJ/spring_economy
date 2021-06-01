package group907.baybikov.springwitch.controllers;

import group907.baybikov.springwitch.dto.UserDto;
import group907.baybikov.springwitch.forms.UserChangeForm;
import group907.baybikov.springwitch.models.User;
import group907.baybikov.springwitch.security.details.UserDetailsImpl;
import group907.baybikov.springwitch.services.PurchaseService;
import group907.baybikov.springwitch.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProfileController {

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/profile")
    public String profilePage(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model) {
        UserDto user = userService.userByEmail(userDetails.getUser().getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));

        model.addAttribute("purchases", purchaseService.getUserPurchase(user.getId()));
        model.addAttribute("user", user);
        return "profile";
    }
    
    @PostMapping("/profile")
    public String profileChange(UserChangeForm form, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        form.setUser(modelMapper.map(userDetails.getUser(), UserDto.class));

        userService.change(form);

        return "redirect:/profile";
    }
}



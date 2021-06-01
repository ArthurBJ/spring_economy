package group907.baybikov.springwitch.controllers;

import group907.baybikov.springwitch.forms.SignUpForm;
import group907.baybikov.springwitch.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;
import java.util.Objects;

@Controller
public class SignUpController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String getSignUpPage(@RequestParam(required = false) String error, Model model) {
        model.addAttribute("signUpForm", new SignUpForm());

        if (error != null) {
            model.addAttribute("error", "Такая почта уже занята");
        }

        return "register";
    }

    @PermitAll
    @PostMapping("/register")
    public String signUp(@Valid SignUpForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> {
                if (Objects.requireNonNull(error.getCodes())[0].equals("PasswordsEquals.signUpForm")) {
                    model.addAttribute("equalsError", error.getDefaultMessage());
                } else if (Objects.requireNonNull(error.getCodes())[0].equals("PasswordHard.signUpForm.password")) {
                    model.addAttribute("hardError", error.getDefaultMessage());
                }
            });

            model.addAttribute("signUpForm", form);
            return "register";
        }

        if (userService.signUp(form)) {
            return "redirect:/login";
        }

        return "redirect:/register?error";

    }
}

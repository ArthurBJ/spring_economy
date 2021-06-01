package group907.baybikov.springwitch.controllers;

import group907.baybikov.springwitch.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ConfirmeController {

    @Autowired
    public UserService userService;

    @GetMapping("/confirm/{code}")
    public String confirm(@PathVariable String code) {
        if (userService.confirm(code)) {
            return "redirect:/profile";
        }

        return "redirect:/";
    }
}

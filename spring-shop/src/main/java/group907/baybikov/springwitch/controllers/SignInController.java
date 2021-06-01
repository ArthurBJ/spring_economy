package group907.baybikov.springwitch.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignInController {

    @GetMapping("/login")
    public String getSignInPage(@RequestParam(required=false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", "Пользователь не найден или почта не подтверждена");
        }
        return "login";
    }
}

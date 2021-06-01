package group907.baybikov.springwitch.controllers;

import group907.baybikov.springwitch.security.details.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InfoController {

    @GetMapping("/advantages")
    public String advantagesPage(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails != null) {
            model.addAttribute("user", userDetails.getUser());
        }
        return "advantages";
    }

    @GetMapping("/stages")
    public String stagesPage(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails != null) {
            model.addAttribute("user", userDetails.getUser());
        }
        return "stages";
    }
}

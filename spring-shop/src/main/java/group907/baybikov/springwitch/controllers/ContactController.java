package group907.baybikov.springwitch.controllers;

import group907.baybikov.springwitch.forms.TelephoneForm;
import group907.baybikov.springwitch.security.details.UserDetailsImpl;
import group907.baybikov.springwitch.services.TelephoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {

    @Autowired
    private TelephoneService telephoneService;

    @GetMapping("/contact")
    public String contact(@RequestParam(required=false) String success, Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails != null) {
            model.addAttribute("user", userDetails.getUser());
        }
        if (success != null) {
            model.addAttribute("success", "Заявка оставлена успешно!");
        }
        return "contact";
    }

    @PostMapping("/contact")
    public String saveTelephone(TelephoneForm form) {
        telephoneService.save(form);

        return "redirect:/contact?success";
    }
}

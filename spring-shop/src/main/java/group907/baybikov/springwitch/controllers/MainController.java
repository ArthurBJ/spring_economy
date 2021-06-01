package group907.baybikov.springwitch.controllers;

import group907.baybikov.springwitch.aspects.LogExecutionTime;
import group907.baybikov.springwitch.security.details.UserDetailsImpl;
import group907.baybikov.springwitch.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping({"/main", "/"})
    @LogExecutionTime
    public String main(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails != null) {
            model.addAttribute("user", userDetails.getUser());
        }
        model.addAttribute("categories", categoryService.getAllCategories());
        return "main";
    }
}

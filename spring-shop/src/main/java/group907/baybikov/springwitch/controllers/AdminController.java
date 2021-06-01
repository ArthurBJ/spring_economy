package group907.baybikov.springwitch.controllers;

import group907.baybikov.springwitch.forms.ProductForm;
import group907.baybikov.springwitch.security.details.UserDetailsImpl;
import group907.baybikov.springwitch.services.CategoryService;
import group907.baybikov.springwitch.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AdminController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @GetMapping("/admin")
    public String admin(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        model.addAttribute("user", userDetails.getUser());
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("productForm", new ProductForm());

        return "admin";
    }

    @PostMapping("/admin")
    public String admin(@Valid ProductForm productForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("productForm", productForm);
            model.addAttribute("categories", categoryService.getAllCategories());
            return "admin";
        }

        productService.save(productForm);

        return "redirect:/services";
    }
}

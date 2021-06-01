package group907.baybikov.springwitch.controllers;

import group907.baybikov.springwitch.aspects.ExceptionThrowing;
import group907.baybikov.springwitch.dto.BasketDto;
import group907.baybikov.springwitch.dto.UserDto;
import group907.baybikov.springwitch.exceptions.BasketNotFoundException;
import group907.baybikov.springwitch.exceptions.ProductNotFoundException;
import group907.baybikov.springwitch.models.User;
import group907.baybikov.springwitch.security.details.UserDetailsImpl;
import group907.baybikov.springwitch.services.BasketService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BasketController {

    @Autowired
    private BasketService basketService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/basket")
    public String basketPage(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        BasketDto basket = basketService.createOrGetBasket(modelMapper.map(userDetails.getUser(), UserDto.class));
        model.addAttribute("basket", basket);
        model.addAttribute("user", userDetails.getUser());
        return "basket";
    }

    @GetMapping("/basketService/add/{id}")
    @ExceptionThrowing
    public String addProduct(@PathVariable long id, @AuthenticationPrincipal UserDetailsImpl userDetails) throws ProductNotFoundException, BasketNotFoundException {
        User user = userDetails.getUser();
        BasketDto basket = basketService.createOrGetBasket(modelMapper.map(user, UserDto.class));
        basketService.addProductInBasket(basket, id);
        return "redirect:/basket";
    }

    @GetMapping("/basketService/delete/{id}")
    public String deleteProduct(@PathVariable long id, @AuthenticationPrincipal UserDetailsImpl userDetails) throws ProductNotFoundException, BasketNotFoundException {
        User user = userDetails.getUser();
        BasketDto basket = basketService.createOrGetBasket(modelMapper.map(user, UserDto.class));

        basketService.deleteProductFromBasket(basket, id);
        return "redirect:/basket";
    }
}

package group907.baybikov.springwitch.controllers;

import group907.baybikov.springwitch.dto.BasketDto;
import group907.baybikov.springwitch.dto.ProductDto;
import group907.baybikov.springwitch.dto.UserDto;
import group907.baybikov.springwitch.exceptions.BasketNotFoundException;
import group907.baybikov.springwitch.models.Basket;
import group907.baybikov.springwitch.models.User;
import group907.baybikov.springwitch.security.details.UserDetailsImpl;
import group907.baybikov.springwitch.services.BasketService;
import group907.baybikov.springwitch.services.PurchaseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private BasketService basketService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/purchase")
    public String buyProducts(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model) throws BasketNotFoundException {
        UserDto user = modelMapper.map(userDetails.getUser(), UserDto.class);
        BasketDto basket = basketService.getUserBasket(user)
                .orElseThrow(() -> new BasketNotFoundException("basket not found"));

        List<ProductDto> products = basket.getProducts();
        if (!products.isEmpty()) {
            purchaseService.save(basket);
            return "redirect:/profile";
        }

        return "redirect:/basket?error=empty";
    }
}

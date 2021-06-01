package group907.baybikov.springwitch.services;


import group907.baybikov.springwitch.dto.BasketDto;
import group907.baybikov.springwitch.dto.ProductDto;
import group907.baybikov.springwitch.dto.UserDto;
import group907.baybikov.springwitch.exceptions.BasketNotFoundException;
import group907.baybikov.springwitch.exceptions.ProductNotFoundException;
import group907.baybikov.springwitch.models.Basket;
import group907.baybikov.springwitch.models.Product;
import group907.baybikov.springwitch.models.User;

import java.util.Optional;

public interface BasketService {
    BasketDto save(BasketDto basket);

    BasketDto createOrGetBasket(UserDto user);

    Optional<BasketDto> getUserBasket(UserDto user);

    BasketDto addProductInBasket(BasketDto basket, Long productId) throws ProductNotFoundException, BasketNotFoundException;

    BasketDto deleteProductFromBasket(BasketDto basket, Long productId) throws ProductNotFoundException, BasketNotFoundException;
}

package group907.baybikov.springwitch.services;

import group907.baybikov.springwitch.dto.BasketDto;
import group907.baybikov.springwitch.dto.ProductDto;
import group907.baybikov.springwitch.dto.UserDto;
import group907.baybikov.springwitch.exceptions.BasketNotFoundException;
import group907.baybikov.springwitch.exceptions.ProductNotFoundException;
import group907.baybikov.springwitch.models.Basket;
import group907.baybikov.springwitch.models.Product;
import group907.baybikov.springwitch.models.User;
import group907.baybikov.springwitch.repositories.BasketRepository;
import group907.baybikov.springwitch.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;

@Service
public class BasketServiceImpl implements BasketService {

    @Autowired
    private BasketRepository basketRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Optional<BasketDto> getUserBasket(UserDto user) {
        return basketRepository.findByUser(modelMapper.map(user, User.class))
                .map(b -> modelMapper.map(b, BasketDto.class));
    }

    @Override
    public BasketDto addProductInBasket(BasketDto basket, Long productId) throws ProductNotFoundException, BasketNotFoundException {
        Basket dbBasket = basketRepository.findById(basket.getId())
                .orElseThrow(() -> new BasketNotFoundException("basket not found"));;

        Product dbProduct = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("product not found"));

        dbBasket.getProducts().add(dbProduct);
        basketRepository.save(dbBasket);

        return modelMapper.map(dbBasket, BasketDto.class);
}

    @Override
    public BasketDto createOrGetBasket(UserDto user) {
        Optional<Basket> maybeBasket = basketRepository.findByUser(modelMapper.map(user, User.class));

        if (!maybeBasket.isPresent()) {
            Basket basket = Basket.builder().products(new HashSet<>()).user(modelMapper.map(user, User.class)).build();
            return modelMapper.map(basketRepository.save(basket), BasketDto.class);
        }

        return modelMapper.map(maybeBasket.get(), BasketDto.class);
    }

    @Override
    public BasketDto save(BasketDto basket) {
        return modelMapper.map(basketRepository.save(modelMapper.map(basket, Basket.class)), BasketDto.class);
    }

    @Override
    public BasketDto deleteProductFromBasket(BasketDto basket, Long productId) throws ProductNotFoundException, BasketNotFoundException  {

        Basket dbBasket = basketRepository.findById(basket.getId())
                .orElseThrow(() -> new BasketNotFoundException("basket not found"));;

        Product dbProduct = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("product not found"));

        dbBasket.getProducts().remove(dbProduct);

        return modelMapper.map(basketRepository.save(dbBasket), BasketDto.class);
    }
}

package group907.baybikov.springwitch.services;

import group907.baybikov.springwitch.dto.BasketDto;
import group907.baybikov.springwitch.dto.PurchaseDto;
import group907.baybikov.springwitch.dto.UserDto;
import group907.baybikov.springwitch.models.Basket;
import group907.baybikov.springwitch.models.Purchase;
import group907.baybikov.springwitch.models.User;
import group907.baybikov.springwitch.repositories.PurchaseRepository;
import group907.baybikov.springwitch.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<PurchaseDto> getUserPurchase(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));

        return purchaseRepository.findPurchaseByCustomer(user)
            .stream().map(p -> modelMapper.map(p, PurchaseDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public void save(BasketDto basketDto) {
        Basket basket = modelMapper.map(basketDto, Basket.class);

        Purchase purchase = Purchase.builder()
                .products(basket.getProducts())
                .customer(basket.getUser())
                .build();

        purchaseRepository.save(modelMapper.map(purchase, Purchase.class));
    }


}

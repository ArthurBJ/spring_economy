package group907.baybikov.springwitch.services;

import group907.baybikov.springwitch.dto.BasketDto;
import group907.baybikov.springwitch.dto.PurchaseDto;
import group907.baybikov.springwitch.dto.UserDto;

import java.util.List;

public interface PurchaseService {
    List<PurchaseDto> getUserPurchase(Long userId);

    void save(BasketDto basket);
}

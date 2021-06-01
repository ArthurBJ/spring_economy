package group907.baybikov.springwitch.repositories;

import group907.baybikov.springwitch.dto.UserDto;
import group907.baybikov.springwitch.models.Purchase;
import group907.baybikov.springwitch.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    List<Purchase> findPurchaseByCustomer(User user);
}

package group907.baybikov.springwitch.repositories;

import group907.baybikov.springwitch.models.Basket;
import group907.baybikov.springwitch.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Long> {
    Optional<Basket> findByUser(User user);
}

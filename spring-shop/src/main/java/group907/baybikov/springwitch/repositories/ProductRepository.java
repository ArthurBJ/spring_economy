package group907.baybikov.springwitch.repositories;

import group907.baybikov.springwitch.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContaining(String name);

    List<Product> findByNameContainingOrderByPrice(String name);

    List<Product> findByNameContainingOrderByPriceDesc(String name);
}

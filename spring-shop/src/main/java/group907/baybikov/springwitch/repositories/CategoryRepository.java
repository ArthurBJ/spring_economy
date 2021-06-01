package group907.baybikov.springwitch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import group907.baybikov.springwitch.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}

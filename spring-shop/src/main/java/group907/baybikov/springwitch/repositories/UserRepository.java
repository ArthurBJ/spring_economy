package group907.baybikov.springwitch.repositories;

import group907.baybikov.springwitch.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaSpecificationExecutor<User>, JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findByConfirmedCode(String code);
}

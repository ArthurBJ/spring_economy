package group907.baybikov.springwitch.repositories;

import group907.baybikov.springwitch.models.Telephone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelephoneRepository extends JpaRepository<Telephone, Long> {

}

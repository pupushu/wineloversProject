package softuni.winelovers.data.repositories.wine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.winelovers.data.models.wine.Wine;

import java.util.List;
import java.util.Optional;

@Repository
public interface WineRepository extends JpaRepository<Wine, String> {
    Optional<Wine> findById(String id);
}

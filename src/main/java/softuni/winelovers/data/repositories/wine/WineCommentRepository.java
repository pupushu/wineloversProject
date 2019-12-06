package softuni.winelovers.data.repositories.wine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.winelovers.data.models.wine.WineComment;

@Repository
public interface WineCommentRepository extends JpaRepository<WineComment, String> {
}

package softuni.winelovers.data.repositories.news;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.winelovers.data.models.news.News;

import java.util.Optional;

@Repository
public interface NewsRepository extends JpaRepository<News, String> {
    Optional<News> findById(String s);
}

package johnatanSSP.streamingFlix.repository;

import johnatanSSP.streamingFlix.entity.Category;
import johnatanSSP.streamingFlix.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {


//    List<Movie> findMovieByCategories(List<Category> categories);
    List<Movie> findByCategories_IdIn(List<Long> categoryIds);
}

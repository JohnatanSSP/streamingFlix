package johnatanSSP.streamingFlix.service;

import johnatanSSP.streamingFlix.entity.Category;
import johnatanSSP.streamingFlix.entity.Movie;
import johnatanSSP.streamingFlix.entity.Streaming;
import johnatanSSP.streamingFlix.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository Repository;
    private final CategoryService categoryService;
    private final StreamingService streamingService;

    public Movie save(Movie movie) {
        movie.setCategories(this.findCategories(movie.getCategories()));
        movie.setStreamings(this.findStreaming(movie.getStreamings()));
        return Repository.save(movie);
    }

    public List<Movie> findAll() {
        return Repository.findAll();
    }

    private List<Category> findCategories(List<Category> categories) {
        List<Category> categoryFound = new ArrayList<>();
        categories.forEach(category -> categoryService
                .findById(category.getId()).ifPresent(categoryFound::add));

        return categoryFound;
    }

    private List<Streaming> findStreaming(List<Streaming> streamings) {
        List<Streaming> streamingsFound = new ArrayList<>();
        streamings.forEach(streaming -> streamingService
                .findById(streaming.getId()).ifPresent(streamingsFound::add));

        return streamingsFound;
    }
}

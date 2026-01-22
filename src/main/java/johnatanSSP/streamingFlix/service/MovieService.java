package johnatanSSP.streamingFlix.service;

import johnatanSSP.streamingFlix.entity.Category;
import johnatanSSP.streamingFlix.entity.Movie;
import johnatanSSP.streamingFlix.entity.Streaming;
import johnatanSSP.streamingFlix.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final CategoryService categoryService;
    private final StreamingService streamingService;

    public Movie save(Movie movie) {
        movie.setCategories(this.findCategories(movie.getCategories()));
        movie.setStreamings(this.findStreaming(movie.getStreamings()));
        return movieRepository.save(movie);
    }

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Optional<Movie> findById(Long id) {
        return movieRepository.findById(id);
    }

    public List<Movie> findByCategory(List<Long> categoryIds) {
        return movieRepository.findByCategories_IdIn(categoryIds);
    }

    public Optional<Movie> update(Long movieId, Movie updateMovie) {
        Optional<Movie> optMovie = movieRepository.findById(movieId);
        if (optMovie.isPresent()) {
            Movie movie = optMovie.get();

            List<Category> categories = this.findCategories(updateMovie.getCategories());
            List<Streaming> streaming = this.findStreaming(updateMovie.getStreamings());

            movie.setTitle(updateMovie.getTitle());
            movie.setDescription(updateMovie.getDescription());
            movie.setYearMovie(updateMovie.getYearMovie());
            movie.setDirector(updateMovie.getDirector());
            movie.setRating(updateMovie.getRating());
            movie.setReleaseDate(updateMovie.getReleaseDate());

            movie.getCategories().clear();
            movie.getCategories().addAll(categories);

            movie.getStreamings().clear();
            movie.getStreamings().addAll(streaming);

            movieRepository.save(movie);
            return Optional.of(movie);
        }
        return Optional.empty();
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

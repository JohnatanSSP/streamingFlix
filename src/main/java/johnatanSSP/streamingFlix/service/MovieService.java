package johnatanSSP.streamingFlix.service;

import johnatanSSP.streamingFlix.entity.Movie;
import johnatanSSP.streamingFlix.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository Repository;

    public Movie save(Movie movie) {
        return Repository.save(movie);
    }

    public List<Movie> findAll() {
        return Repository.findAll();
    }
}

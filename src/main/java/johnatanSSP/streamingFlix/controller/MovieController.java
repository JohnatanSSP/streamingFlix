package johnatanSSP.streamingFlix.controller;

import johnatanSSP.streamingFlix.controller.request.MovieRequest;
import johnatanSSP.streamingFlix.controller.response.MovieResponse;
import johnatanSSP.streamingFlix.entity.Movie;
import johnatanSSP.streamingFlix.mapper.MovieMapper;
import johnatanSSP.streamingFlix.repository.MovieRepository;
import johnatanSSP.streamingFlix.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/streamingflix/movie")
public class MovieController {
    private final MovieService Service;

    @PostMapping
    public ResponseEntity<MovieResponse> save(@RequestBody MovieRequest request) {
        Movie savedMovie = Service.save(MovieMapper.toMovie(request));
        return ResponseEntity.ok(MovieMapper.toMovieResponse(savedMovie));
    }

    @GetMapping
    public ResponseEntity<List<MovieResponse>> findAll() {
        List<Movie> movies = Service.findAll();
        List<MovieResponse> response = movies.stream()
                .map(MovieMapper::toMovieResponse)
                .toList();
        return ResponseEntity.ok(response);
    }
}

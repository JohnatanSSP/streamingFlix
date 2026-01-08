package johnatanSSP.streamingFlix.controller;

import johnatanSSP.streamingFlix.repository.MovieRepository;
import johnatanSSP.streamingFlix.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/streamingflix/movie")
public class MovieController {
    private final MovieService Service;
}

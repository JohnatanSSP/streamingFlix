package johnatanSSP.streamingFlix.service;

import johnatanSSP.streamingFlix.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository Repository;
}

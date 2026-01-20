package johnatanSSP.streamingFlix.controller.request;

import java.time.LocalDate;
import java.util.List;

public record MovieRequest(
        String title,
        String description,
        Integer yearMovie,
        String director,
        double rating,
        LocalDate releaseDate,
        List<Long> categoryIds,
        List<Long> streamingIds
) {
}

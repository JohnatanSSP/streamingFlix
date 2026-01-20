package johnatanSSP.streamingFlix.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.List;

public record MovieRequest(
        String title,
        String description,
        Integer yearMovie,
        String director,
        double rating,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        LocalDate releaseDate,

        List<Long> categoryIds,
        List<Long> streamingIds
) {
}

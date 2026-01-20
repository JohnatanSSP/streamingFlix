package johnatanSSP.streamingFlix.controller.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record MovieResponse(
        Long id,
        String title,
        String description,
        Integer yearMovie,
        String director,
        double rating,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        LocalDate releaseDate,
        
        List<CategoryResponse> categories,
        List<StreamingResponse> streamings
) {
}

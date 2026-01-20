package johnatanSSP.streamingFlix.mapper;

import johnatanSSP.streamingFlix.controller.request.MovieRequest;
import johnatanSSP.streamingFlix.controller.response.CategoryResponse;
import johnatanSSP.streamingFlix.controller.response.MovieResponse;
import johnatanSSP.streamingFlix.controller.response.StreamingResponse;
import johnatanSSP.streamingFlix.entity.Category;
import johnatanSSP.streamingFlix.entity.Movie;
import johnatanSSP.streamingFlix.entity.Streaming;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@UtilityClass
public class MovieMapper {
    public static Movie toMovie(MovieRequest request) {

        List<Category> categories = request.categoryIds()
                .stream()
                .map(categoryId -> Category.builder().id(categoryId).build()).toList();

        List<Streaming> streamings = request.streamingIds()
                .stream()
                .map(streamingId -> Streaming.builder().id(streamingId).build()).toList();

        return Movie.builder()
                .title(request.title())
                .description(request.description())
                .yearMovie(request.yearMovie())
                .director(request.director())
                .rating(request.rating())
                .releaseDate(request.releaseDate().atStartOfDay())
                .categories(categories)
                .streamings(streamings)
                .build();
    }

    public static MovieResponse toMovieResponse(Movie movie) {

        List<CategoryResponse> categories = Optional.ofNullable( movie.getCategories())
                .orElse(List.of())
                .stream()
                .map(category -> CategoryMapper.ToCategoryResponse(category))
                .toList();

        List<StreamingResponse> streamings = Optional.ofNullable(movie.getStreamings())
                .orElse(List.of())
                .stream()
                .map(streaming -> StreamingMapper.ToStreamingResponse(streaming))
                .toList();


        return MovieResponse.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .description(movie.getDescription())
                .yearMovie(movie.getYearMovie())
                .director(movie.getDirector())
                .rating(movie.getRating())
                .releaseDate(movie.getReleaseDate().toLocalDate())
                .categories(categories)
                .streamings(streamings)
                .build();
    }
}

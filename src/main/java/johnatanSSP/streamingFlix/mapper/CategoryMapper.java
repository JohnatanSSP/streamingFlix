package johnatanSSP.streamingFlix.mapper;

import johnatanSSP.streamingFlix.controller.request.CategoryRequest;
import johnatanSSP.streamingFlix.controller.response.CategoryResponse;
import johnatanSSP.streamingFlix.entity.Category;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {

    public static Category toCategory(CategoryRequest request) {
        return Category.builder().name(request.name()).build();
    }

    public static CategoryResponse ToCategoryResponse(Category category) {
        return CategoryResponse
                .builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}

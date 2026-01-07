package johnatanSSP.streamingFlix.controller;


import johnatanSSP.streamingFlix.controller.request.CategoryRequest;
import johnatanSSP.streamingFlix.controller.response.CategoryResponse;
import johnatanSSP.streamingFlix.entity.Category;
import johnatanSSP.streamingFlix.mapper.CategoryMapper;
import johnatanSSP.streamingFlix.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/streamingflix/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService Service;

    @GetMapping()
    public ResponseEntity<List<CategoryResponse>> getAllCategory() {
        List<Category> categories = Service.findAll();
        List<CategoryResponse> list = categories
                .stream()
                .map(CategoryMapper::ToCategoryResponse)
                .toList();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping()
    public ResponseEntity<CategoryResponse> saveCategory(@RequestBody CategoryRequest request) {
        Category newCategory = CategoryMapper.toCategory(request);
        Category savedCategory = Service.save(newCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(CategoryMapper.ToCategoryResponse(savedCategory));
    }

    @GetMapping("/{id}")
    public CategoryResponse getCategoryById(@PathVariable Long id) {
        return Service.findById(id)
                .map(category -> ResponseEntity.ok(CategoryMapper.ToCategoryResponse(category)))
                .orElse(ResponseEntity.notFound().build()).getBody();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoryById(@PathVariable Long id) {
        Service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}

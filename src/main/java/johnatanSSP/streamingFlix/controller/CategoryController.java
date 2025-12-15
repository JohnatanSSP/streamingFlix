package johnatanSSP.streamingFlix.controller;


import johnatanSSP.streamingFlix.entity.Category;
import johnatanSSP.streamingFlix.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/streamingflix/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService Service;

    @GetMapping()
    public List<Category> getAllCategory() {
        return Service.findAll();
    }
}

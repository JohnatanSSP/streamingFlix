package johnatanSSP.streamingFlix.service;


import johnatanSSP.streamingFlix.entity.Category;
import johnatanSSP.streamingFlix.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository Repository;

    public List<Category> findAll(){
       return Repository.findAll();
    }
}

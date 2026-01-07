package johnatanSSP.streamingFlix.service;


import johnatanSSP.streamingFlix.entity.Category;
import johnatanSSP.streamingFlix.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository Repository;

    public List<Category> findAll(){
       return Repository.findAll();
    }

    public Category save(Category category){
        return Repository.save(category);
    }

    public Optional<Category> findById(Long id){
        return Repository.findById(id);
    }

    public void deleteById(Long id){
        Repository.deleteById(id);
    }
}

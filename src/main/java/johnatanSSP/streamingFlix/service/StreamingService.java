package johnatanSSP.streamingFlix.service;

import johnatanSSP.streamingFlix.entity.Category;
import johnatanSSP.streamingFlix.entity.Streaming;
import johnatanSSP.streamingFlix.repository.StreamingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StreamingService {

    private final StreamingRepository Repository;

    public List<Streaming> findAll(){
        return Repository.findAll();
    }

    public Streaming save(Streaming streaming){
        return Repository.save(streaming);
    }

    public Optional<Streaming> findById(Long id){
        return Repository.findById(id);
    }

    public void deleteById(Long id){
        Repository.deleteById(id);
    }
}

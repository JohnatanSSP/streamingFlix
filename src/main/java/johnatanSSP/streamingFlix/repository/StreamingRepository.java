package johnatanSSP.streamingFlix.repository;

import com.sun.jdi.LongValue;
import johnatanSSP.streamingFlix.entity.Streaming;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreamingRepository extends JpaRepository<Streaming, Long> {

}

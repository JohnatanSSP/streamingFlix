package johnatanSSP.streamingFlix.controller;


import johnatanSSP.streamingFlix.controller.request.StreamingRequest;
import johnatanSSP.streamingFlix.controller.response.StreamingResponse;
import johnatanSSP.streamingFlix.entity.Streaming;
import johnatanSSP.streamingFlix.mapper.StreamingMapper;
import johnatanSSP.streamingFlix.service.StreamingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/streamingflix/streaming")
@RequiredArgsConstructor
public class StreamingController {

    private final StreamingService Service;

    @GetMapping()
    public ResponseEntity<List<StreamingResponse>> getAllStreaming() {
        List<Streaming> streamings = Service.findAll();
        List<StreamingResponse> list = streamings
                .stream()
                .map(StreamingMapper::ToStreamingResponse)
                .toList();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping()
    public ResponseEntity<StreamingResponse> save(@RequestBody StreamingRequest request) {
        Streaming newStreaming = StreamingMapper.toStreaming(request);
        Streaming savedStreaming = Service.save(newStreaming);
        return ResponseEntity.status(HttpStatus.CREATED).body(StreamingMapper.ToStreamingResponse(savedStreaming));
    }

    @GetMapping("/{id}")
    public StreamingResponse getStreamingById(@PathVariable Long id) {
        return Service.findById(id)
                .map(streaming -> ResponseEntity.ok(StreamingMapper.ToStreamingResponse(streaming)))
                .orElse(ResponseEntity.notFound().build()).getBody();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStreamingById(@PathVariable Long id) {
        Service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}

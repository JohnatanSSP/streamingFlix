package johnatanSSP.streamingFlix.mapper;

import johnatanSSP.streamingFlix.controller.request.StreamingRequest;
import johnatanSSP.streamingFlix.controller.response.CategoryResponse;
import johnatanSSP.streamingFlix.controller.response.StreamingResponse;
import johnatanSSP.streamingFlix.entity.Streaming;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StreamingMapper {

    public static Streaming toStreaming(StreamingRequest request) {
        return Streaming.builder().name(request.name()).build();
    }

    public static StreamingResponse ToStreamingResponse(Streaming streaming) {
        return StreamingResponse
                .builder()
                .id(streaming.getId())
                .name(streaming.getName())
                .build();
    }
}

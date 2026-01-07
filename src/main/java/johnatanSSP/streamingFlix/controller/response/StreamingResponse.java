package johnatanSSP.streamingFlix.controller.response;

import lombok.Builder;

@Builder
public record StreamingResponse(Long id, String name) {
}

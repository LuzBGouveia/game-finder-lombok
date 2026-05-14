package fiap.com.br.gamefinder.dto;

import fiap.com.br.gamefinder.model.Platform;
import jakarta.validation.constraints.NotBlank;

public record PlatformRequest(
        @NotBlank
        String name
) {
    public Platform toEntity() {
        return Platform.builder().name(name).build();
    }
}

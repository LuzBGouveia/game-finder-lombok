package fiap.com.br.gamefinder.dto;

import fiap.com.br.gamefinder.model.Platform;

public record PlatformReponse(
        Long id,
        String name
) {
    public static PlatformReponse fromEntity(Platform platform) {
        return new PlatformReponse(
                platform.getId(),
                platform.getName()
        );
    }
}

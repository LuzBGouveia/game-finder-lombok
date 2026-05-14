package fiap.com.br.gamefinder.dto;

import fiap.com.br.gamefinder.model.Genre;
import jakarta.validation.constraints.NotBlank;

public record GenreRequest(
        @NotBlank
        String name
) {
    public Genre toEntity() {
        return Genre.builder().name(name).build();
    }
}

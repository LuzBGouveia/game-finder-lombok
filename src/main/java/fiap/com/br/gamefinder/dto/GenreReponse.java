package fiap.com.br.gamefinder.dto;

import fiap.com.br.gamefinder.model.Genre;

public record GenreReponse(
        Long id,
        String name
) {
    public static GenreReponse fromEntity(Genre genre) {
        return new GenreReponse(
                genre.getId(),
                genre.getName()
        );
    }
}

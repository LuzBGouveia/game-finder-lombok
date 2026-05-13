package fiap.com.br.gamefinder.dto;

import fiap.com.br.gamefinder.model.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

public record GameResponse(
        Long id,
        String name,
        LocalDate launch,
        BigDecimal price,
        Set<Genre> genres,
        Set<Developer> developers,
        Set<Publisher> publishers,
        Franchise franchise
) {
    public static GameResponse fromEntity(Game game) {
        return new GameResponse(
                game.getId(),
                game.getName(),
                game.getLaunch(),
                game.getPrice(),
                game.getGenres(),
                game.getDevelopers(),
                game.getPublishers(),
                game.getFranchise()
        );
    }
}

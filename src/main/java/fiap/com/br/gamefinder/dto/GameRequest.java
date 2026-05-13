package fiap.com.br.gamefinder.dto;


import fiap.com.br.gamefinder.model.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

public record GameRequest(
        @NotBlank
        String name,

        @PastOrPresent
        @NotNull
        LocalDate launch,

        @NotNull
        BigDecimal price,

        @NotNull
        @Size(min = 1)
        Set<Genre> genres,

        @NotNull
        @Size(min = 1)
        Set<Developer> developers,

        @NotNull
        @Size(min = 1)
        Set<Publisher> publishers,

        Franchise franchise
) {
    public Game toEntity() {
        return Game.builder()
                .name(name)
                .launch(launch)
                .price(price)
                .genres(genres)
                .developers(developers)
                .publishers(publishers)
                .franchise(franchise)
                .build();
    }
}

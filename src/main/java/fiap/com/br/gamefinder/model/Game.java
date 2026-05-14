package fiap.com.br.gamefinder.model;

import fiap.com.br.gamefinder.controller.GameController;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.hateoas.EntityModel;

import java.time.LocalDate;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Entity
@AllArgsConstructor
@Builder
@Data
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private LocalDate releaseDate;

    private Double rating;

    @OneToMany
    private Genre genre;

    @OneToMany
    private Platform platform;

    private String coverUrl;

    private String backdropUrl;

    private Boolean inWishList;

    public EntityModel<Game> toEntityModel() {
        var linkAllGame = linkTo(methodOn(GameController.class).findAll()).withRel("all-games").withTitle("All games");
        var linkSelf = linkTo(methodOn(GameController.class).findById(id)).withSelfRel().withTitle("Games details");

        return EntityModel.of(this, linkSelf, linkAllGame);
    }
}

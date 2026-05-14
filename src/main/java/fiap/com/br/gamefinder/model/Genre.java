package fiap.com.br.gamefinder.model;

import fiap.com.br.gamefinder.controller.GenreController;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.EntityModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public EntityModel<Genre> toEntityModel() {
        var linkAllGenre = linkTo(methodOn(GenreController.class).findAll()).withRel("all-genres").withTitle("All Genres");
        var linkSelf = linkTo(methodOn(GenreController.class).findById(id)).withSelfRel().withTitle("Genre details");

        return EntityModel.of(this, linkSelf, linkAllGenre);
    }
}

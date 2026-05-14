package fiap.com.br.gamefinder.model;

import fiap.com.br.gamefinder.controller.GenreController;
import fiap.com.br.gamefinder.controller.PlatformController;
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
@Table(name = "platforms")
@Data
public class Platform {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public EntityModel<Platform> toEntityModel() {
        var linkAllGenre = linkTo(methodOn(PlatformController.class).findAll()).withRel("all-platforms").withTitle("All Platforms");
        var linkSelf = linkTo(methodOn(PlatformController.class).findById(id)).withSelfRel().withTitle("Platform details");

        return EntityModel.of(this, linkSelf, linkAllGenre);
    }
}

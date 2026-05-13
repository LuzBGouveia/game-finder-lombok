package fiap.com.br.gamefinder.model;

import fiap.com.br.gamefinder.controller.GameController;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import org.springframework.hateoas.EntityModel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate launch;

    private BigDecimal price;

    @OneToMany(mappedBy = "Game")
    private Set<Genre> genres;

    @ManyToMany
    private Set<Developer> developers;

    @ManyToMany
    private Set<Publisher> publishers;

    @ManyToOne
    private Franchise franchise;

    public Game(String name, LocalDate launch, BigDecimal price, Set<Genre> genres, Set<Developer> developers, Set<Publisher> publishers, Franchise franchise) {
        this.name = name;
        this.launch = launch;
        this.price = price;
        this.genres = genres;
        this.developers = developers;
        this.publishers = publishers;
        this.franchise = franchise;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getLaunch() {
        return launch;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public Set<Developer> getDevelopers() {
        return developers;
    }

    public Set<Publisher> getPublishers() {
        return publishers;
    }

    public Franchise getFranchise() {
        return franchise;
    }

    public EntityModel<Game> toEntityModel() {
        var linkAllProfessional = linkTo(methodOn(GameController.class).findAll()).withRel("all-games").withTitle("All games");
        var linkSelf = linkTo(methodOn(GameController.class).findById(id)).withSelfRel().withTitle("Professional details");

        return EntityModel.of(this, linkSelf, linkAllProfessional);
    }
}

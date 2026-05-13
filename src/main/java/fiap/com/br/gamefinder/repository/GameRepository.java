package fiap.com.br.gamefinder.repository;

import fiap.com.br.gamefinder.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
    public Game findByname(String name);
}

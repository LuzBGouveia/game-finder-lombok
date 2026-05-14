package fiap.com.br.gamefinder.service;

import fiap.com.br.gamefinder.dto.GenreRequest;
import fiap.com.br.gamefinder.model.Genre;
import fiap.com.br.gamefinder.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreService {
    private final GenreRepository genreRepository;

    public List<Genre> findAll() {return genreRepository.findAll();}

    public Genre findById(Long id) {return genreRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Gênero não encontrado.")
    );}

    public Genre save(GenreRequest genreRequest) {return genreRepository.save(genreRequest.toEntity());};

    public Genre update(Long id, GenreRequest genreRequest) {
        findById(id);
        Genre genre = genreRequest.toEntity();
        genre.setId(id);
        return genreRepository.save(genre);
    }

    public void delete(Long id) {
        findById(id);
        genreRepository.deleteById(id);}
}

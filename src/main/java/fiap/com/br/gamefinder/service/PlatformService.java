package fiap.com.br.gamefinder.service;
import fiap.com.br.gamefinder.dto.PlatformRequest;
import fiap.com.br.gamefinder.model.Platform;
import fiap.com.br.gamefinder.repository.PlatformRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlatformService {
    private final PlatformRepository platformRepository;

    public List<Platform> findAll() {return platformRepository.findAll();}

    public Platform findById(Long id) {return platformRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Plataforma não encontrada.")
    );}

    public Platform save(PlatformRequest platformRequest) {return platformRepository.save(platformRequest.toEntity());};

    public Platform update(Long id, PlatformRequest platformRequest) {
        findById(id);
        Platform platform = platformRequest.toEntity();
        platform.setId(id);
        return platformRepository.save(platform);
    }

    public void delete(Long id) {
        findById(id);
        platformRepository.deleteById(id);}
}

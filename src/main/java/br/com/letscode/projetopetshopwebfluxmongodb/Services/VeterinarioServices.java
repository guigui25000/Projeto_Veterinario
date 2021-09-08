package br.com.letscode.projetopetshopwebfluxmongodb.Services;


import br.com.letscode.projetopetshopwebfluxmongodb.Entity.VeterinarioDTO;
import br.com.letscode.projetopetshopwebfluxmongodb.Repository.VeterinarioRepository;
import br.com.letscode.projetopetshopwebfluxmongodb.Utils.DTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class VeterinarioServices {
    
    @Autowired
    private VeterinarioRepository repository;

    public Mono<VeterinarioDTO> findById(String id) {
        return repository.findById(id)
                .map(DTOConverter::vetEntityToDto);
    }

    public Void deleteVeterinario(String id) {
        return Void.TYPE.cast(repository.deleteById(id));
    }

    public Mono<VeterinarioDTO> updateVeterinario(Mono<VeterinarioDTO> veterinarioDTO, String id) {
        return repository.findById(id)
                .flatMap(v -> veterinarioDTO.map(DTOConverter::vetDtoToEntity)
                        .doOnNext(e -> e.setId(id)))
                .flatMap(repository::save)
                .map(DTOConverter::vetEntityToDto);
    }

    public Mono<VeterinarioDTO> createVeterinario(Mono<VeterinarioDTO> veterinarioDTO) {
        return veterinarioDTO
                .map(DTOConverter::vetDtoToEntity)
                .flatMap(repository::insert)
                .map(DTOConverter::vetEntityToDto);
    }

    public Flux<VeterinarioDTO> getAll() {
        return repository.findAll()
                .map(DTOConverter::vetEntityToDto);
    }
}

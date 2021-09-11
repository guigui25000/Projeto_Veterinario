package br.com.letscode.projetopetshopwebfluxmongodb.Services;


import br.com.letscode.projetopetshopwebfluxmongodb.Entity.Veterinario;
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

    public Mono<Veterinario> findById(String id) {
        return repository.findById(id);
    }

    public Void deleteVeterinario(String id) {
        return Void.TYPE.cast(repository.deleteById(id));
    }

    public Mono<Veterinario> updateVeterinario(Mono<Veterinario> veterinarioDTO, String id) {
        return repository.findById(id)
                .flatMap(e -> veterinarioDTO)
                .doOnNext(p -> p.setId(id))
                .flatMap(repository::save);
    }

    public Mono<Veterinario> createVeterinario(Mono<Veterinario> veterinarioDTO) {
        return veterinarioDTO
                .flatMap(repository::insert);
    }

    public Flux<Veterinario> getAll() {
        return repository.findAll();
    }
}

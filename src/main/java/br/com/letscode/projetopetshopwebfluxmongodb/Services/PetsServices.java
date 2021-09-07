package br.com.letscode.projetopetshopwebfluxmongodb.Services;


import br.com.letscode.projetopetshopwebfluxmongodb.DTO.PetDTO;
import br.com.letscode.projetopetshopwebfluxmongodb.Entity.Pet;
import br.com.letscode.projetopetshopwebfluxmongodb.Repository.PetRepository;
import br.com.letscode.projetopetshopwebfluxmongodb.Utils.DTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PetsServices {

    @Autowired
    private PetRepository repository;

    public Mono<PetDTO> createPet(Mono<PetDTO> pet) {
        return pet
                .map(DTOConverter::dtoToEntity)
                .flatMap(repository::insert)
                .map(DTOConverter::entityToDto);
    }

    public Flux<PetDTO> getAll() {
        return repository.findAll()
                .map(DTOConverter::entityToDto);
    }

    public Mono<PetDTO> findById(String id) {
        return repository.findById(id)
                .map(DTOConverter::entityToDto);
    }

    public Mono<Void> deletePet(String id) {
        return repository.findById(id)
                .map(Void.TYPE::cast);
    }

    public Mono<PetDTO> updatePet(Mono<PetDTO> petDTO, String id) {
        return repository.findById(id)
                .flatMap(p -> petDTO.map(DTOConverter::dtoToEntity)
                        .doOnNext(e -> e.setId(id)))
                .flatMap(repository::save)
                .map(DTOConverter::entityToDto);
    }
}

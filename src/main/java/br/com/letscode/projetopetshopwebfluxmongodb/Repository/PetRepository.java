package br.com.letscode.projetopetshopwebfluxmongodb.Repository;

import br.com.letscode.projetopetshopwebfluxmongodb.Entity.Pet;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PetRepository extends ReactiveMongoRepository<Pet, String> {

}

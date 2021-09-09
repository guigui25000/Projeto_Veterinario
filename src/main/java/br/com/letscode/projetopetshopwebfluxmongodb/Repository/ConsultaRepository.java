package br.com.letscode.projetopetshopwebfluxmongodb.Repository;

import br.com.letscode.projetopetshopwebfluxmongodb.Entity.Consulta;
import br.com.letscode.projetopetshopwebfluxmongodb.Entity.Pet;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ConsultaRepository extends ReactiveMongoRepository<Consulta, String> {
    Pet findByPetId(String id);
}

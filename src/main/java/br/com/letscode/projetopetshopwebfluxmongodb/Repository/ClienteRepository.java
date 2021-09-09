package br.com.letscode.projetopetshopwebfluxmongodb.Repository;

import br.com.letscode.projetopetshopwebfluxmongodb.Entity.Cliente;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ClienteRepository extends ReactiveMongoRepository<Cliente,String> {
}

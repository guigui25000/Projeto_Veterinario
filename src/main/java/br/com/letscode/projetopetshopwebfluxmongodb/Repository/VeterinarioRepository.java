package br.com.letscode.projetopetshopwebfluxmongodb.Repository;


import br.com.letscode.projetopetshopwebfluxmongodb.Entity.Veterinario;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeterinarioRepository extends ReactiveMongoRepository<Veterinario, String> {
}

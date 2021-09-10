package br.com.letscode.projetopetshopwebfluxmongodb.Services;

import br.com.letscode.projetopetshopwebfluxmongodb.Entity.Cliente;
import br.com.letscode.projetopetshopwebfluxmongodb.Repository.ClienteRepository;
import br.com.letscode.projetopetshopwebfluxmongodb.Utils.DTOConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Flux<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    public Mono<Cliente> findById(String id) {
        return clienteRepository.findById(id);
    }

    public Mono<Void> deleteCliente(String id) {
        return clienteRepository.deleteById(id);
    }

    public Mono<Cliente> createCliente(Mono<Cliente> cliente) {
        return Mono.from(clienteRepository.insert(cliente));

    }
    public Mono<Cliente> updateCliente(Mono<Cliente> cliente,String id) {
        return clienteRepository.findById(id)
                .flatMap(e -> cliente)
                .doOnNext(p -> p.setId(id))
                .flatMap(clienteRepository::save);
    }
}

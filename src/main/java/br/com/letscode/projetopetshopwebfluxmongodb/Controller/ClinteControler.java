package br.com.letscode.projetopetshopwebfluxmongodb.Controller;

import br.com.letscode.projetopetshopwebfluxmongodb.DTO.PetDTO;
import br.com.letscode.projetopetshopwebfluxmongodb.Entity.Cliente;
import br.com.letscode.projetopetshopwebfluxmongodb.Services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/cliente")
public class ClinteControler {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<Flux<Cliente>> getAll() {
        return ResponseEntity.ok().body(clienteService.getAll());

    }

    @GetMapping("{id}")
    public ResponseEntity<Mono<Cliente>> getById(@PathVariable String id) {
        return ResponseEntity.ok().body(clienteService.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Mono<Void>> deletePet(@PathVariable String id) {
        return ResponseEntity.ok().body(clienteService.deleteCliente(id));
    }

    @PostMapping("create")
    public ResponseEntity<Mono<Cliente>> createPet(@RequestBody Mono<Cliente> cliente) {
        return ResponseEntity.ok().body(clienteService.createCliente(cliente));
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Mono<Cliente>> updatePet(@RequestBody Mono<Cliente> cliente) {
        return ResponseEntity.ok().body(clienteService.updateCliente(cliente));
    }

}

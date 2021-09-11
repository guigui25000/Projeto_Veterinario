package br.com.letscode.projetopetshopwebfluxmongodb.Controller;

import br.com.letscode.projetopetshopwebfluxmongodb.Entity.Veterinario;
import br.com.letscode.projetopetshopwebfluxmongodb.Services.VeterinarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/veterinarios")
public class VeterinarioController {
    @Autowired
    private VeterinarioServices services;

    @GetMapping
    public ResponseEntity<Flux<Veterinario>> getAll() {
        return ResponseEntity.ok().body(services.getAll());

    }

    @GetMapping("{id}")
    public ResponseEntity<Mono<Veterinario>> getById(@PathVariable String id) {
        return ResponseEntity.ok().body(services.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable String id) {
        return ResponseEntity.ok().body(services.deleteVeterinario(id));
    }

    @PostMapping("create")
    public ResponseEntity<Mono<Veterinario>> createPet(@RequestBody Mono<Veterinario> veterinarioDTO) {
        return ResponseEntity.ok().body(services.createVeterinario(veterinarioDTO));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Mono<Veterinario>> updatePet(@RequestBody Mono<Veterinario> veterinarioDTO, @PathVariable String id) {
        return ResponseEntity.ok().body(services.updateVeterinario(veterinarioDTO, id));
    }
}

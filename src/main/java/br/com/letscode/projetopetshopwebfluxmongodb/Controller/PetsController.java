package br.com.letscode.projetopetshopwebfluxmongodb.Controller;


import br.com.letscode.projetopetshopwebfluxmongodb.DTO.PetDTO;
import br.com.letscode.projetopetshopwebfluxmongodb.DTO.PetDTORetorno;
import br.com.letscode.projetopetshopwebfluxmongodb.Services.PetsServices;
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

@RestController()
@RequestMapping("/pets")
public class PetsController {
    @Autowired
    private PetsServices services;

    @GetMapping
    public ResponseEntity<Flux<PetDTO>> getAll() {
        return ResponseEntity.ok().body(services.getAll());

    }

    @GetMapping("{id}")
    public ResponseEntity<Mono<PetDTO>> getById(@PathVariable String id) {
        return ResponseEntity.ok().body(services.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Mono<Void>> deletePet(@PathVariable String id) {
        return ResponseEntity.ok().body(services.deletePet(id));
    }

    @PostMapping("create")
    public ResponseEntity<Flux<PetDTORetorno>> createPet(@RequestBody PetDTO petDTO) {
        return ResponseEntity.ok().body(services.createPet(petDTO));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Mono<PetDTO>> updatePet(@RequestBody Mono<PetDTO> petDTO, @PathVariable String id) {
        return ResponseEntity.ok().body(services.updatePet(petDTO, id));
    }

}
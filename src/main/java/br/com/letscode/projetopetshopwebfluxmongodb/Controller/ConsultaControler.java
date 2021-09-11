package br.com.letscode.projetopetshopwebfluxmongodb.Controller;

import br.com.letscode.projetopetshopwebfluxmongodb.DTO.ConsultaDTO;
import br.com.letscode.projetopetshopwebfluxmongodb.DTO.RetornoConsultaDTO;
import br.com.letscode.projetopetshopwebfluxmongodb.Entity.Cliente;
import br.com.letscode.projetopetshopwebfluxmongodb.Entity.Consulta;
import br.com.letscode.projetopetshopwebfluxmongodb.Services.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/consulta")
public class ConsultaControler {

    @Autowired
    private ConsultaService consultaService;

    @GetMapping
    public ResponseEntity<Flux<Consulta>> getAll() {
        return ResponseEntity.ok().body(consultaService.getAll());

    }

    @GetMapping("{id}")
    public ResponseEntity<Mono<Consulta>> getById(@PathVariable String id) {
        return ResponseEntity.ok().body(consultaService.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Mono<Void>> deleteConsulta(@PathVariable String id) {
        return ResponseEntity.ok().body(consultaService.deleteConsulta(id));
    }

    @PostMapping("create")
    public ResponseEntity<Flux<RetornoConsultaDTO>> createConsulta(@RequestBody ConsultaDTO consultaDTO) {
        return ResponseEntity.ok().body(consultaService.createConsulta(consultaDTO));
    }
}

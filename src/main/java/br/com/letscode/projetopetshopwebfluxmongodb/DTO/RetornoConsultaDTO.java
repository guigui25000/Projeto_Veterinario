package br.com.letscode.projetopetshopwebfluxmongodb.DTO;

import br.com.letscode.projetopetshopwebfluxmongodb.Entity.VeterinarioDTO;
import lombok.Data;
import reactor.core.publisher.Mono;

@Data
public class RetornoConsultaDTO {
    private PetDTO pet;
    private VeterinarioDTO veterinario;
    private String descricao;
}

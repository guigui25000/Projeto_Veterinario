package br.com.letscode.projetopetshopwebfluxmongodb.DTO;

import br.com.letscode.projetopetshopwebfluxmongodb.Entity.Veterinario;
import lombok.Data;

@Data
public class RetornoConsultaDTO {
    private PetDTORetorno pet;
    private Veterinario veterinario;
    private String descricao;
}

package br.com.letscode.projetopetshopwebfluxmongodb.DTO;

import br.com.letscode.projetopetshopwebfluxmongodb.Entity.Pet;
import br.com.letscode.projetopetshopwebfluxmongodb.Entity.Veterinario;
import lombok.Data;

@Data
public class ConulstaDTOCriarConsulta {
    private Pet pet;
    private Veterinario veterinario;
    private String descricao;
}

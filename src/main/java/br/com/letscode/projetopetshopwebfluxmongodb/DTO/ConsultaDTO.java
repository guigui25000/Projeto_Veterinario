package br.com.letscode.projetopetshopwebfluxmongodb.DTO;

import br.com.letscode.projetopetshopwebfluxmongodb.Entity.Pet;
import br.com.letscode.projetopetshopwebfluxmongodb.Entity.Veterinario;
import lombok.Data;

@Data
public class ConsultaDTO {

    private String petID;
    private String veterinarioID;
    private String descricao;

}

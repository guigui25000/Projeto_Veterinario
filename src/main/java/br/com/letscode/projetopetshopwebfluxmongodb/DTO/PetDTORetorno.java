package br.com.letscode.projetopetshopwebfluxmongodb.DTO;

import br.com.letscode.projetopetshopwebfluxmongodb.Entity.Cliente;
import lombok.Data;

@Data
public class PetDTORetorno {

    private String especie;

    private String sexo;

    private Integer idade;

    private Double peso;

    private Cliente cliente;
}

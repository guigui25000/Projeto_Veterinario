package br.com.letscode.projetopetshopwebfluxmongodb.Entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
@Data
public class VeterinarioDTO {

    private String id;

    private String CRMV;

    private String nome;

    private Integer idade;

    private String endereco;
}

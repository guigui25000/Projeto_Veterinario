package br.com.letscode.projetopetshopwebfluxmongodb.Entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Veterinario {
    @Id
    private String id;

    private String CRMV;

    private String nome;

    private Integer idade;

    private String endereco;
}

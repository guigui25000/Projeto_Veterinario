package br.com.letscode.projetopetshopwebfluxmongodb.Entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Cliente {

    @Id
    private String id;

    private String nome;
    private Integer idade;
    private Endereco endereco;
    private String telefone;
}

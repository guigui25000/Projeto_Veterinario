package br.com.letscode.projetopetshopwebfluxmongodb.Entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Pet {

    @Id
    private String id;

    private String especie;

    private String sexo;

    private Integer idade;

    private Double peso;

    @DBRef
    private Cliente cliente;
}

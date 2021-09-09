package br.com.letscode.projetopetshopwebfluxmongodb.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Cliente {

    private String nome;
    private Integer idade;
    private Endereco endereco;
    private String telefone;
}

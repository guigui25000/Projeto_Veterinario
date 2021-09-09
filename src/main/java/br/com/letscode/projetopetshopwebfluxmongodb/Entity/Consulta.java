package br.com.letscode.projetopetshopwebfluxmongodb.Entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
@Component
public class Consulta {
    @Id
    private String id;

    @DBRef
    private Pet pet;
    private LocalDate data;
    @DBRef
    private Veterinario veterinario;
    private String descricao;

}

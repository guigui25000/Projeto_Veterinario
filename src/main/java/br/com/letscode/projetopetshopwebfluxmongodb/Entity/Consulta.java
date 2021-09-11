package br.com.letscode.projetopetshopwebfluxmongodb.Entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
@Component
public class Consulta {
    @Id
    private String id;

    private String petId;
    private LocalDate data;
    private String veterinarioId;
    private String descricao;

}

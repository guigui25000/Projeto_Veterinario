package br.com.letscode.projetopetshopwebfluxmongodb.Services;

import br.com.letscode.projetopetshopwebfluxmongodb.DTO.ConsultaDTO;
import br.com.letscode.projetopetshopwebfluxmongodb.DTO.ConulstaDTOCriarConsulta;
import br.com.letscode.projetopetshopwebfluxmongodb.Entity.Consulta;
import br.com.letscode.projetopetshopwebfluxmongodb.Entity.Pet;
import br.com.letscode.projetopetshopwebfluxmongodb.Entity.Veterinario;
import br.com.letscode.projetopetshopwebfluxmongodb.Repository.ConsultaRepository;
import br.com.letscode.projetopetshopwebfluxmongodb.Utils.DTOConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.beans.Beans;

@Service
public class ConsultaService {
    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private PetsServices petsServices;
    @Autowired
    private VeterinarioServices veterinarioServices;

    public Flux<Consulta> getAll() {
        return consultaRepository.findAll();
    }

    public Mono<Consulta> findById(String id) {
        return consultaRepository.findById(id);
    }

    public Mono<Void> deleteConsulta(String id) {
        return consultaRepository.deleteById(id);
    }

    public Mono<Consulta> createConsulta(ConsultaDTO consultaDTO) {
        ConulstaDTOCriarConsulta consuDTO = new ConulstaDTOCriarConsulta();
        Pet pet = getPet(consultaDTO);
        Veterinario veterinario = getVeterinario(consultaDTO);
        consuDTO.setPet(pet);
        consuDTO.setVeterinario(veterinario);
        consuDTO.setDescricao(consultaDTO.getDescricao());
        return Mono.just(consuDTO)
                .map(DTOConverter::consuDtoToEntity)
                .flatMap(consultaRepository::insert);
    }

    private Veterinario getVeterinario(ConsultaDTO consultaDTO) {
        Veterinario veterinario = new Veterinario();
        BeanUtils.copyProperties(veterinarioServices.findById(consultaDTO.getVeterinarioID())
                .map(DTOConverter::vetDtoToEntity),veterinario);
        return veterinario;
    }

    private Pet getPet(ConsultaDTO consultaDTO) {
        Pet pet = new Pet();
        BeanUtils.copyProperties(petsServices.findById(consultaDTO.getPetID())
                .map(DTOConverter::dtoToEntity),pet);
        return pet;
    }
}

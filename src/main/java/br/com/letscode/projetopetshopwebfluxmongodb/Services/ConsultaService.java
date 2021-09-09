package br.com.letscode.projetopetshopwebfluxmongodb.Services;

import br.com.letscode.projetopetshopwebfluxmongodb.DTO.ConsultaDTO;
import br.com.letscode.projetopetshopwebfluxmongodb.DTO.ConulstaDTOCriarConsulta;
import br.com.letscode.projetopetshopwebfluxmongodb.Entity.Consulta;
import br.com.letscode.projetopetshopwebfluxmongodb.Entity.Pet;
import br.com.letscode.projetopetshopwebfluxmongodb.Entity.Veterinario;
import br.com.letscode.projetopetshopwebfluxmongodb.Repository.ConsultaRepository;
import br.com.letscode.projetopetshopwebfluxmongodb.Utils.DTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

    //Erro q preciso falar com o bruno
    public Mono<Consulta> createConsulta(ConsultaDTO consultaDTO) {
        ConulstaDTOCriarConsulta consuDTO = new ConulstaDTOCriarConsulta();
        consuDTO.setPet(petsServices.findById(consultaDTO.getPetID()).map(DTOConverter::dtoToEntity).block());
        consuDTO.setVeterinario(veterinarioServices.findById(consultaDTO.getVeterinarioID()).map(DTOConverter::vetDtoToEntity).block());
        consuDTO.setDescricao(consultaDTO.getDescricao());
        return Mono.just(consuDTO)
                .map(DTOConverter::consuDtoToEntity)
                .flatMap(consultaRepository::insert);
    }
}

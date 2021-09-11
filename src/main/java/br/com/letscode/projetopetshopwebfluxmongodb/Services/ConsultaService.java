package br.com.letscode.projetopetshopwebfluxmongodb.Services;

import br.com.letscode.projetopetshopwebfluxmongodb.DTO.ConsultaDTO;
import br.com.letscode.projetopetshopwebfluxmongodb.DTO.PetDTO;
import br.com.letscode.projetopetshopwebfluxmongodb.DTO.RetornoConsultaDTO;
import br.com.letscode.projetopetshopwebfluxmongodb.Entity.Consulta;
import br.com.letscode.projetopetshopwebfluxmongodb.Entity.Pet;
import br.com.letscode.projetopetshopwebfluxmongodb.Entity.Veterinario;
import br.com.letscode.projetopetshopwebfluxmongodb.Entity.VeterinarioDTO;
import br.com.letscode.projetopetshopwebfluxmongodb.Repository.ConsultaRepository;
import br.com.letscode.projetopetshopwebfluxmongodb.Utils.DTOConverter;
import org.springframework.beans.BeanUtils;
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

    public Flux<RetornoConsultaDTO> createConsulta(ConsultaDTO consultaDTO) {
        RetornoConsultaDTO consuDTO = new RetornoConsultaDTO();
        consuDTO.setVeterinario(getVeterinario(consultaDTO));
        consuDTO.setPet(getPet(consultaDTO));
        consuDTO.setDescricao(consultaDTO.getDescricao());
        return Flux.just(consultaDTO)
                .map(DTOConverter::consuDtoToEntity)
                .flatMap(consultaRepository::insert)
                .map(e -> consuDTO);

    }

    private VeterinarioDTO getVeterinario(ConsultaDTO consultaDTO) {
        String vetid = consultaDTO.getVeterinarioID();
        VeterinarioDTO vet = new VeterinarioDTO();
        veterinarioServices.findById(vetid).subscribe(e -> {
            vet.setCRMV(e.getCRMV());
            vet.setEndereco(e.getEndereco());
            vet.setIdade(e.getIdade());
            vet.setNome(e.getNome());
        });
        return vet;
    }

    private PetDTO getPet(ConsultaDTO consultaDTO) {
        PetDTO pet = new PetDTO();
        String petid = consultaDTO.getPetID();
        petsServices.findById(petid).subscribe(e -> {
            pet.setIdade(e.getIdade());
            pet.setCliente(e.getCliente());
            pet.setPeso(e.getPeso());
            pet.setSexo(e.getSexo());
            pet.setEspecie(e.getEspecie());
        });
        return pet;
    }
}

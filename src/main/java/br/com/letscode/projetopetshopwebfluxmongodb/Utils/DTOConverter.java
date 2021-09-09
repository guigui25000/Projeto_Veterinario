package br.com.letscode.projetopetshopwebfluxmongodb.Utils;

import br.com.letscode.projetopetshopwebfluxmongodb.DTO.ConsultaDTO;
import br.com.letscode.projetopetshopwebfluxmongodb.DTO.ConulstaDTOCriarConsulta;
import br.com.letscode.projetopetshopwebfluxmongodb.DTO.PetDTO;
import br.com.letscode.projetopetshopwebfluxmongodb.Entity.Consulta;
import br.com.letscode.projetopetshopwebfluxmongodb.Entity.Pet;
import br.com.letscode.projetopetshopwebfluxmongodb.Entity.Veterinario;
import br.com.letscode.projetopetshopwebfluxmongodb.Entity.VeterinarioDTO;
import br.com.letscode.projetopetshopwebfluxmongodb.Repository.ConsultaRepository;
import ch.qos.logback.core.joran.util.beans.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class DTOConverter {



    public static PetDTO entityToDto(Pet pet) {
        PetDTO petDTO = new PetDTO();
        BeanUtils.copyProperties(pet, petDTO);
        return petDTO;
    }

    public static Pet dtoToEntity(PetDTO petDTO) {
        Pet pet = new Pet();
        BeanUtils.copyProperties(petDTO, pet);
        return pet;
    }

    public static VeterinarioDTO vetEntityToDto(Veterinario veterinario) {
        VeterinarioDTO veterinarioDTO = new VeterinarioDTO();
        BeanUtils.copyProperties(veterinario, veterinarioDTO);
        return veterinarioDTO;
    }

    public static Veterinario vetDtoToEntity(VeterinarioDTO veterinarioDTO) {
        Veterinario veterinario = new Veterinario();
        BeanUtils.copyProperties(veterinarioDTO, veterinario);
        return veterinario;
    }

    public static Consulta consuDtoToEntity(ConulstaDTOCriarConsulta consultaDTO){
        Consulta consulta = new Consulta();
        consulta.setData(LocalDate.now());
        consulta.setPet(consultaDTO.getPet());
        consulta.setVeterinario(consultaDTO.getVeterinario());
        consulta.setDescricao(consultaDTO.getDescricao());
        return consulta;
    }
}

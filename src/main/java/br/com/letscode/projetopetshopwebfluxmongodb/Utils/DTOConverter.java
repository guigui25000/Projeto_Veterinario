package br.com.letscode.projetopetshopwebfluxmongodb.Utils;

import br.com.letscode.projetopetshopwebfluxmongodb.DTO.ConsultaDTO;
import br.com.letscode.projetopetshopwebfluxmongodb.DTO.PetDTO;
import br.com.letscode.projetopetshopwebfluxmongodb.Entity.Consulta;
import br.com.letscode.projetopetshopwebfluxmongodb.Entity.Pet;
import br.com.letscode.projetopetshopwebfluxmongodb.Entity.Veterinario;
import org.springframework.beans.BeanUtils;

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



    public static Consulta consuDtoToEntity(ConsultaDTO consultaDTO){
        Consulta consulta = new Consulta();
        consulta.setData(LocalDate.now());
        consulta.setPetId(consultaDTO.getPetID());
        consulta.setVeterinarioId(consultaDTO.getVeterinarioID());
        consulta.setDescricao(consultaDTO.getDescricao());
        return consulta;
    }


}

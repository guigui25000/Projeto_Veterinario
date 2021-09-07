package br.com.letscode.projetopetshopwebfluxmongodb.Utils;

import br.com.letscode.projetopetshopwebfluxmongodb.DTO.PetDTO;
import br.com.letscode.projetopetshopwebfluxmongodb.Entity.Pet;
import ch.qos.logback.core.joran.util.beans.BeanUtil;
import org.springframework.beans.BeanUtils;

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
}

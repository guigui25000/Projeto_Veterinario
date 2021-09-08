package br.com.letscode.projetopetshopwebfluxmongodb.Utils;

import br.com.letscode.projetopetshopwebfluxmongodb.DTO.PetDTO;
import br.com.letscode.projetopetshopwebfluxmongodb.Entity.Pet;
import br.com.letscode.projetopetshopwebfluxmongodb.Entity.Veterinario;
import br.com.letscode.projetopetshopwebfluxmongodb.Entity.VeterinarioDTO;
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
}

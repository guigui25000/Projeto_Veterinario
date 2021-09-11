package br.com.letscode.projetopetshopwebfluxmongodb.Services;


import br.com.letscode.projetopetshopwebfluxmongodb.DTO.PetDTO;
import br.com.letscode.projetopetshopwebfluxmongodb.DTO.PetDTORetorno;
import br.com.letscode.projetopetshopwebfluxmongodb.Entity.Cliente;
import br.com.letscode.projetopetshopwebfluxmongodb.Entity.Pet;
import br.com.letscode.projetopetshopwebfluxmongodb.Repository.ClienteRepository;
import br.com.letscode.projetopetshopwebfluxmongodb.Repository.PetRepository;
import br.com.letscode.projetopetshopwebfluxmongodb.Utils.DTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PetsServices {

    @Autowired
    private PetRepository repository;
    @Autowired
    private ClienteRepository clienteRepository;

    public Flux<PetDTORetorno> createPet(PetDTO pet) {
        Pet nPet = new Pet();
            nPet.setIdade(pet.getIdade());
            nPet.setCliente(pet.getCliente());
            nPet.setPeso(pet.getPeso());
            nPet.setSexo(pet.getSexo());
            nPet.setEspecie(pet.getEspecie());
        PetDTORetorno petRet = construirPet(nPet);
        return Flux.just(pet)
                .map(DTOConverter::dtoToEntity)
                .flatMap(repository::insert)
                .map(e -> petRet);
    }

    public Flux<PetDTO> getAll() {
        return repository.findAll()
                .map(DTOConverter::entityToDto);
    }

    public Mono<PetDTO> findById(String id) {
        return repository.findById(id)
                .map(DTOConverter::entityToDto);
    }

    public Mono<Void> deletePet(String id) {
        return repository.findById(id)
                .map(Void.TYPE::cast);
    }

    public Mono<PetDTO> updatePet(Mono<PetDTO> petDTO, String id) {
        return repository.findById(id)
                .flatMap(p -> petDTO.map(DTOConverter::dtoToEntity)
                        .doOnNext(e -> e.setId(id)))
                .flatMap(repository::save)
                .map(DTOConverter::entityToDto);
    }

    public Cliente getCliente(String clienteid){
        Cliente cliente = new Cliente();
        clienteRepository.findById(clienteid).subscribe(e -> {
            cliente.setIdade(e.getIdade());
            cliente.setEndereco(e.getEndereco());
            cliente.setNome(e.getNome());
            cliente.setTelefone(e.getTelefone());
        });
        return cliente;

    }

    public PetDTORetorno construirPet(Pet pet){
        PetDTORetorno petDTORetorno = new PetDTORetorno();
        petDTORetorno.setIdade(pet.getIdade());
        petDTORetorno.setPeso(pet.getPeso());
        petDTORetorno.setCliente(getCliente(pet.getCliente()));
        petDTORetorno.setSexo(pet.getSexo());
        petDTORetorno.setEspecie(pet.getEspecie());
        return  petDTORetorno;

    }
}

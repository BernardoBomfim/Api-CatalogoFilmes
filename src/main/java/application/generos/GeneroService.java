package application.generos;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class GeneroService {
    @Autowired
    private GeneroRepository generoRepo;

    public Iterable<GeneroDTO> getAll(){
        return generoRepo.findAll().stream().map(GeneroDTO::new).toList();
    }

    public GeneroDTO insert(GeneroDTO novoGenero){
        return new GeneroDTO(generoRepo.save(new Genero(novoGenero)));
    }
    public GeneroDTO getOne(long id) {
        Optional<Genero> resultado = generoRepo.findById(id);
        if(resultado.isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Aluno não encontrado"
            );
        }
        return new GeneroDTO(resultado.get());

    }
}
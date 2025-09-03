package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import application.generos.GeneroDTO;
import application.generos.GeneroRepository;
import application.generos.GeneroService;
import application.generos.GeneroinsertDTO;

@RestController
@RequestMapping("/generos")

public class GeneroController {
    @Autowired
    private GeneroRepository generoRepo;

    @Autowired
    private GeneroService generoService;

    @GetMapping
    public Iterable<GeneroDTO> getALL() {
        return generoService.getAll();
    }

    @GetMapping("/{id}")
    public GeneroDTO getOne(@PathVariable long id) {
        return generoService.getOne(id);
    }

    @PostMapping
    public GeneroDTO insert(@RequestBody GeneroinsertDTO novoGenero){
        return generoService.insert(novoGenero);
    }
    @PutMapping("/{id}")
    public GeneroDTO update(@PathVariable long id, @RequestBody GeneroDTO novosDados){
        return generoService.update(id, novosDados);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable long id) {
        if(!generoRepo.existsById(id)){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Aluno não encontrada");
        }
        generoRepo.deleteById(id);
    }
}

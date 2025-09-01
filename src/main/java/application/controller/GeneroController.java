package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping
    public GeneroDTO insert(@RequestBody GeneroinsertDTO novoGenero){
        return generoService.insert(novoGenero);
    }
    
}

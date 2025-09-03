package application.filmes;

import application.generos.Genero;

public record FilmeDTO(long id, String titulo, Genero genero){
    FilmeDTO (Filme dados){
        this(dados.getId,
        dados.getTitulo(),
        new GeneroDTO(dados.getGenero()));
    }
}
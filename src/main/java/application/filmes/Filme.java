package application.filmes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "filmes")
@Setter
@Getter
@NoArgsConstructor
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Columm(nullable = false)
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "id_genero")
    private Genero genero;
    
    public Filme(FilmeDTO dados){
        this.setId(dados.id());
        this.setTitulo(dados.titulo());
        this.setGenero(new Genero(dados.genero()));
        
    }
}



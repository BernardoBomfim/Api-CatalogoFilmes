package application.filmes;

@RestController
@requestMapping("/filmes")
public class FilmeController {
    @Autowired
    private FilmeRepository repository;
}

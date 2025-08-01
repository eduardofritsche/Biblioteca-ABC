package dev.biblioteca.Biblioteca_ABC.repository;

import dev.biblioteca.Biblioteca_ABC.model.Biblioteca;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BibliotecaRepository {

    @Getter
    private final List<Biblioteca> bibliotecas;

    @PostConstruct
    public void init(){
        Biblioteca biblioteca = new Biblioteca(1, "Saraiva", "3525-3525");

        bibliotecas.add(biblioteca);
    }

    public List<Biblioteca> findAll(){
        return bibliotecas;
    }
}

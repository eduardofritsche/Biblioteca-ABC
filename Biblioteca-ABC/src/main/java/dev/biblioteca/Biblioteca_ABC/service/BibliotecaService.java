package dev.biblioteca.Biblioteca_ABC.service;

import dev.biblioteca.Biblioteca_ABC.model.Biblioteca;
import dev.biblioteca.Biblioteca_ABC.repository.BibliotecaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BibliotecaService {

    private final BibliotecaRepository bibliotecaRepository;

    public List<Biblioteca> findAll(){
        return bibliotecaRepository.getBibliotecas();
    }
}

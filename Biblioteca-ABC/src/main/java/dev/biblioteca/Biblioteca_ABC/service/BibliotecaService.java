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

    public Biblioteca save(Biblioteca biblioteca){
        return bibliotecaRepository.save(biblioteca);
    }

    public Biblioteca findById(Integer id){
        return bibliotecaRepository.findById(id);
    }

    public void delete(Integer id){
        bibliotecaRepository.delete(id);
    }

    public Biblioteca update(Integer id, Biblioteca biblioteca){
        Biblioteca update = findById(id);

        if(biblioteca.getNome() != null && !biblioteca.getNome().isBlank()){
            update.setNome(biblioteca.getNome());
        }

        if(biblioteca.getTelefone() != null && !biblioteca.getTelefone().isBlank()){
            update.setTelefone(biblioteca.getTelefone());
        }

        return bibliotecaRepository.update(update.getId(), update);
    }
}

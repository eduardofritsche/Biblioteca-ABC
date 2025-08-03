package dev.biblioteca.Biblioteca_ABC.service;

import dev.biblioteca.Biblioteca_ABC.model.*;
import dev.biblioteca.Biblioteca_ABC.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    private final AutorRepository autorRepository = new AutorRepository();

    public List<Autor> findAll(){return autorRepository.findAll();}

    public Autor findById(Integer id){return autorRepository.findById(id);
    }
    public Autor save(Autor autor){
        return autorRepository.save(autor);
    }

    public void delete(Integer id){
        autorRepository.delete(id);
    }

    public Autor update(Integer idAutor, Autor autor){
        Autor update = findById(idAutor);

        if(autor.getNomeAutor() != null && !autor.getNomeAutor().isBlank()){
            update.setNomeAutor(autor.getNomeAutor());
        }

        if(autor.getCpfAutor() != null){
            update.setCpfAutor(autor.getCpfAutor());
        }

        if(autor.getIdadeAutor() != null){
            update.setIdadeAutor(autor.getIdadeAutor());
        }

        return autorRepository.update(update.getIdAutor(), update);
    }
}

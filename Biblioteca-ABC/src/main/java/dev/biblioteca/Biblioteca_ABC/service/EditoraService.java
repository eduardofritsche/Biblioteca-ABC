package dev.biblioteca.Biblioteca_ABC.service;

import dev.biblioteca.Biblioteca_ABC.model.*;
import dev.biblioteca.Biblioteca_ABC.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditoraService {

    private final EditoraRepository editoraRepository = new EditoraRepository();

    public List<Editora> findAll(){return editoraRepository.findAll();}

    public Editora findById(Integer idEditora){return editoraRepository.findById(idEditora);
    }
    public Editora save(Editora editora){
        return editoraRepository.save(editora);
    }

    public void delete(Integer idEditora){
        editoraRepository.delete(idEditora);
    }

    public Editora update(Integer idEditora, Editora editora){
        Editora update = findById(idEditora);

        if(editora.getNomeEditora() != null && !editora.getNomeEditora().isBlank()){
            update.setNomeEditora(editora.getNomeEditora());
        }

        if(editora.getEnderecoEditora() != null && !editora.getEnderecoEditora().isBlank()){
            update.setEnderecoEditora(editora.getEnderecoEditora());
        }

        if(editora.getTelefoneEditora() != null && !editora.getTelefoneEditora().isBlank()){
            update.setTelefoneEditora(editora.getTelefoneEditora());
        }

        return editoraRepository.update(update.getIdEditora(), update);
    }
}
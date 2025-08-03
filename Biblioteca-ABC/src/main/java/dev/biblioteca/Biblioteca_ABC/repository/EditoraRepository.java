package dev.biblioteca.Biblioteca_ABC.repository;

import dev.biblioteca.Biblioteca_ABC.model.Autor;
import dev.biblioteca.Biblioteca_ABC.model.Editora;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class EditoraRepository {

    @Getter
    private final List<Editora> editoras = new ArrayList<>();
    private AtomicInteger atomicInteger = new AtomicInteger(3);

    @PostConstruct
    public void init(){
        Editora editora1 = new Autor(1, "CNN", "AV.Repblica Argentina 1001","91919191");
        Editora editora2 = new Autor(2, "CAPPA", "Rua Oswaldo Cruz 998","12312312412");
        Editora editora3 = new Autor(3, "YES", "Rua Cassiano Ricardo 98","2346545323");

        editoras.add(editora1);
        editoras.add(editora2);
        editoras.add(editora3);
    }

    public Editora save(Editora editora){
        atomicInteger.incrementAndGet();
        editora.setIdEditora(atomicInteger.get());
        editoras.add(editora);
        return editora;
    }

    public List<Editora> findAll() {
        return editoras;
    }


    public Editora findById(Integer idEditora){
        for(Editora editora: editoras){
            if(editora.getIdEditora().equals(idEditora)){
                return editora;
            }
        }
        return null;
    }

    public void delete(Integer idEditora){
        for(Editora editora : editoras){
            if(editora.getIdEditora().equals(idEditora)){
                editoras.remove(editora);
                break;
            }
        }
    }

    public Editora update(Integer idEditora, Editora editora){
        editoras.set(idEditora-1, editora);
        return editora;
    }
}
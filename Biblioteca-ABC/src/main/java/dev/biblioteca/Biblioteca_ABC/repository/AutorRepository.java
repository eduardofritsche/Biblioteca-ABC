package dev.biblioteca.Biblioteca_ABC.repository;

import dev.biblioteca.Biblioteca_ABC.model.Autor;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AutorRepository {

    @Getter
    private final List<Autor> autores = new ArrayList<>();
    private AtomicInteger atomicInteger = new AtomicInteger(3);

    @PostConstruct
    public void init(){
        Autor autor1 = new Autor(1, "Roberval", "132.111.234-90",32);
        Autor autor2 = new Autor(2, "Adilson", "183.293.109.29",44);
        Autor autor3 = new Autor(3, "Ilson", "871.998.929-12",88);

        autores.add(autor1);
        autores.add(autor2);
        autores.add(autor3);
    }

    public Autor save(Autor autor){
        atomicInteger.incrementAndGet();
        autor.setIdAutor(atomicInteger.get());
        autores.add(autor);
        return autor;
    }
    public List<Autor> findAll() {
        return autores;
    }


    public Autor findById(Integer idAutor){
        for(Autor autor: autores){
            if(autor.getIdAutor().equals(idAutor)){
                return autor;
            }
        }
        return null;
    }

    public void delete(Integer idAutor){
        for(Autor autor: autores){
            if(autor.getIdAutor().equals(idAutor)){
                autores.remove(autores);
                break;
            }
        }
    }

    public Autor update(Integer idAutor, Autor autor){
        autores.set(idAutor-1, autor);
        return autor;
    }
}

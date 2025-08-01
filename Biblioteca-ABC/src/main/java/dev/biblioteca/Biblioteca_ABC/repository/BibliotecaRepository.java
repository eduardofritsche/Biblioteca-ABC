package dev.biblioteca.Biblioteca_ABC.repository;

import dev.biblioteca.Biblioteca_ABC.model.Biblioteca;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
@RequiredArgsConstructor
public class BibliotecaRepository {

    @Getter
    private final List<Biblioteca> bibliotecas;
    private AtomicInteger atomicInteger = new AtomicInteger(3);

    @PostConstruct
    public void init(){
        Biblioteca biblioteca1 = new Biblioteca(1, "Saraiva", "3525-3525");
        Biblioteca biblioteca2 = new Biblioteca(2, "Cunda", "3758-0000");
        Biblioteca biblioteca3 = new Biblioteca(3, "Amadeus", "6535-8888");

        bibliotecas.add(biblioteca1);
        bibliotecas.add(biblioteca2);
        bibliotecas.add(biblioteca3);
    }

    public Biblioteca save(Biblioteca biblioteca){
        atomicInteger.incrementAndGet();
        biblioteca.setId(atomicInteger.get());
        bibliotecas.add(biblioteca);
        return biblioteca;
    }

    public Biblioteca findById(Integer id){
        for(Biblioteca biblioteca: bibliotecas){
            if(biblioteca.getId().equals(id)){
                return biblioteca;
            }
        }
        return null;
    }

    public void delete(Integer id){
        for(Biblioteca biblioteca: bibliotecas){
            if(biblioteca.getId().equals(id)){
                bibliotecas.remove(biblioteca);
                break;
            }
        }
    }

    public Biblioteca update(Integer id, Biblioteca biblioteca){
        bibliotecas.set(id-1, biblioteca);
        return biblioteca;
    }
}

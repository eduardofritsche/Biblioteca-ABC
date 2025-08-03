package dev.biblioteca.Biblioteca_ABC.repository;

import dev.biblioteca.Biblioteca_ABC.model.Livro;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class LivroRepository {

    @Getter
    private final List<Livro> livros = new ArrayList<>();
    private final AtomicInteger atomicInteger = new AtomicInteger(3);

    @PostConstruct
    public void init() {
        Livro livro1 = new Livro(1, "1234-5678", "Dom Casmurro", "Romance clássico", 1899, 256);
        Livro livro2 = new Livro(2, "4321-8765", "1984", "Distopia sobre vigilância", 1949, 328);
        Livro livro3 = new Livro(3, "9999-1111", "A Revolução dos Bichos", "Satírico e político", 1945, 112);

        livros.add(livro1);
        livros.add(livro2);
        livros.add(livro3);
    }

    public Livro save(Livro livro) {
        livro.setId(atomicInteger.incrementAndGet());
        livros.add(livro);
        return livro;
    }

    public List<Livro> findAll() {
        return livros;
    }

    public Livro findById(Integer id) {
        return livros.stream()
                .filter(l -> l.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Livro update(Integer id, Livro livro) {
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).getId().equals(id)) {
                livro.setId(id);
                livros.set(i, livro);
                return livro;
            }
        }
        return null;
    }

    public void delete(Integer id) {
        livros.removeIf(l -> l.getId().equals(id));
    }
}

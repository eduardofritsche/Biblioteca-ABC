package dev.biblioteca.Biblioteca_ABC.service;

import dev.biblioteca.Biblioteca_ABC.model.Livro;
import dev.biblioteca.Biblioteca_ABC.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;

    public List<Livro> findAll() {
        return livroRepository.findAll();
    }

    public Livro save(Livro livro) {
        return livroRepository.save(livro);
    }

    public Livro findById(Integer id) {
        return livroRepository.findById(id);
    }

    public void delete(Integer id) {
        livroRepository.delete(id);
    }

    public Livro update(Integer id, Livro livro) {
        Livro update = findById(id);

        if (update == null) {
            return null; // ou lançar uma exceção customizada se preferir
        }

        if (livro.getISSN() != null && !livro.getISSN().isBlank()) {
            update.setISSN(livro.getISSN());
        }

        if (livro.getTitulo() != null && !livro.getTitulo().isBlank()) {
            update.setTitulo(livro.getTitulo());
        }

        if (livro.getSinopse() != null && !livro.getSinopse().isBlank()) {
            update.setSinopse(livro.getSinopse());
        }

        if (livro.getAno() != null) {
            update.setAno(livro.getAno());
        }

        if (livro.getNumPagina() != null) {
            update.setNumPagina(livro.getNumPagina());
        }

        return livroRepository.update(update.getId(), update);
    }
}

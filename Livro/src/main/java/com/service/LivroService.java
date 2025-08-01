package com.calculo.demo.service;

import com.calculo.demo.model.Livro;
import com.calculo.demo.repository.LivroRepository;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @PostConstruct
    public void init() {
        Livro livro1 = new Livro();
        livro1.setISSN("1234-5678");
        livro1.setTitulo("Agua");
        livro1.setSinopse("Eu quero tomar agua");
        livro1.setAno(2025);
        livro1.setNumPagina(547);
        livroRepository.save(livro1);

        Livro livro2 = new Livro();
        livro2.setISSN("9876-4321");
        livro2.setTitulo("Yuri Alberto e Memphis Depay");
        livro2.setSinopse("Dois Crack do meu Curintia!");
        livro2.setAno(2025);
        livro2.setNumPagina(112);
        livroRepository.save(livro2);
    }

    public Livro save(Livro livro) {
        return livroRepository.save(livro);
    }

    public List<Livro> findAll() {
        return livroRepository.findAll();
    }

    public Livro findById(Integer id) {
        return livroRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());
    }

    public Livro update(Integer id, Livro livro) {
        Livro update = findById(id);

        if (livro.getISSN() != null) {
            update.setISSN(livro.getISSN());
        }

        if (livro.getTitulo() != null) {
            update.setTitulo(livro.getTitulo());
        }

        if (livro.getSinopse() != null) {
            update.setSinopse(livro.getSinopse());
        }

        if (livro.getAno() != null) {
            update.setAno(livro.getAno());
        }

        if (livro.getNumPagina() != null) {
            update.setNumPagina(livro.getNumPagina());
        }

        return livroRepository.save(update);
    }

    public void delete(Integer id) {
        Livro delete = findById(id);
        livroRepository.delete(delete);
    }
}

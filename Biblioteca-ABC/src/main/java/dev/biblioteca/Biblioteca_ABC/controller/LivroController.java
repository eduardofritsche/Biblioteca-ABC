package dev.biblioteca.Biblioteca_ABC.controller;

import dev.biblioteca.Biblioteca_ABC.model.Livro;
import dev.biblioteca.Biblioteca_ABC.service.LivroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Livro>> findAll() {
        try {
            var result = livroService.findAll();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Livro> save(
            @RequestBody Livro livro) {
        try {
            var result = livroService.save(livro);
            return new ResponseEntity<>(result,
                    HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(null,
                    HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/findById/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Integer id) {
        try {
            var result = livroService.findById(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            livroService.delete(id);
            return ResponseEntity.noContent().build(); // status 204
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build(); // status 400
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Livro> update(@PathVariable Integer id,
                                             @RequestBody Livro livroUpdate) {
        try {
            var result = livroService.update(id, livroUpdate);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}

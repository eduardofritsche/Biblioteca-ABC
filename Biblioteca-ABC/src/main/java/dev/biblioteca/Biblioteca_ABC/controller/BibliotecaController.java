package dev.biblioteca.Biblioteca_ABC.controller;

import dev.biblioteca.Biblioteca_ABC.model.Biblioteca;
import dev.biblioteca.Biblioteca_ABC.service.BibliotecaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/bibliotecas")
@RequiredArgsConstructor
public class BibliotecaController {

    private final BibliotecaService bibliotecaService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Biblioteca>> findAll(){
        try {
            var result = bibliotecaService.findAll();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch(Exception ex){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Biblioteca> find(@RequestBody Biblioteca biblioteca){
        try {
            var result = bibliotecaService.save(biblioteca);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch(Exception ex){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Biblioteca> findById(@PathVariable Integer id){
        try {
            var result = bibliotecaService.findById(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch(Exception ex){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try {
            bibliotecaService.delete(id);
            return ResponseEntity.noContent().build();
        } catch(Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Biblioteca> update(@PathVariable Integer id, @RequestBody Biblioteca biblioteca){
        try {
            var result = bibliotecaService.update(id, biblioteca);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch(Exception ex){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}

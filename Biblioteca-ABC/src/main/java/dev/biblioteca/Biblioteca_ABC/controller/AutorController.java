package dev.biblioteca.Biblioteca_ABC.controller;

import dev.biblioteca.Biblioteca_ABC.model.Autor;
import dev.biblioteca.Biblioteca_ABC.service.AutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/autores")
@RequiredArgsConstructor
public class AutorController {

    private final AutorService autorService = new AutorService();

    @GetMapping("/findAll")
    public ResponseEntity<List<Autor>> findAll(){
        try {
            var result = autorService.findAll();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch(Exception ex){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Autor> find(@RequestBody Autor autor){
        try {
            var result = autorService.save(autor);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch(Exception ex){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Autor> findById(@PathVariable Integer id){
        try {
            var result = autorService.findById(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch(Exception ex){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try {
            autorService.delete(id);
            return ResponseEntity.noContent().build();
        } catch(Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Autor> update(@PathVariable Integer id, @RequestBody Autor autor){
        try {
            var result = autorService.update(id, autor);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch(Exception ex){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}

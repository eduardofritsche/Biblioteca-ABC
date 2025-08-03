package dev.biblioteca.Biblioteca_ABC.controller;

import dev.biblioteca.Biblioteca_ABC.model.Editora;
import dev.biblioteca.Biblioteca_ABC.service.EditoraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/editoras")
@RequiredArgsConstructor
public class EditoraController {

    private final EditoraService editoraService = new EditoraService();

    @GetMapping("/findAll")
    public ResponseEntity<List<Editora>> findAll(){
        try {
            var result = editoraService.findAll();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch(Exception ex){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Editora> find(@RequestBody Editora editora){
        try {
            var result = editoraService.save(editora);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch(Exception ex){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Editora> findById(@PathVariable Integer idEditora){
        try {
            var result = editoraService.findById(idEditora);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch(Exception ex){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer idEditora){
        try {
            editoraService.delete(idEditora);
            return ResponseEntity.noContent().build();
        } catch(Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Editora> update(@PathVariable Integer idEditora, @RequestBody Editora editora){
        try {
            var result = editoraService.update(idEditora, editora);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch(Exception ex){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}

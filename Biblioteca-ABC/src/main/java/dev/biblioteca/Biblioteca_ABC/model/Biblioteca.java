package dev.biblioteca.Biblioteca_ABC.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Biblioteca {
    private Integer id;
    private String nome;
    private String telefone;
}

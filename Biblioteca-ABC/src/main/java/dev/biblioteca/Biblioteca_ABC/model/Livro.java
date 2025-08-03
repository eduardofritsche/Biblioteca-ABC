package dev.biblioteca.Biblioteca_ABC.model;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@Data
public class    Livro {

    private Integer id;
    private String ISSN;
    private String titulo;
    private String sinopse;
    private Integer ano;
    private Integer numPagina;

}


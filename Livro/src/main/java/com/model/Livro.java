package com.calculo.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "Livro")
public class    Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String ISSN;
    private String titulo;
    private String sinopse;
    private Integer ano;
    private Integer numPagina;

}


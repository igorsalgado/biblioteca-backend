package com.project.biblioteca.api.dto;

import com.project.biblioteca.api.dto.AutorDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ObraDTO {

    private Long id;
    private String titulo;
    private String editora;
    private String foto;
    private AutorDTO autor;
}

package com.project.biblioteca.api.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ObraRequest {

        @NotNull
        private String titulo;

        @NotNull
        private String editora;

        @NotNull
        private String foto;

        @Valid
        @NotNull
        private AutorIdRequest autor;
}
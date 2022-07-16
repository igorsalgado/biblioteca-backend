package com.project.biblioteca.domain.model;

import com.project.biblioteca.domain.utils.ValidationGroups;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

@Getter
@Setter
@Entity
public class Obra {

    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @NotBlank
    @Column(name = "titulo_obra")
    private String titulo;

    @NotBlank
    @Column(name = "editora_obra")
    private String editora;

    @NotBlank
    @Column(name = "foto_obra")
    private String foto;

    @Valid
    @NotNull
    @ConvertGroup(from = Default.class, to = ValidationGroups.AutorId.class)
    @ManyToOne
    @JoinColumn(name = "autor_id") // Nome da coluna na tabela de relacionamento
    private Autor autor;
}

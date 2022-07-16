package com.project.biblioteca.api.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter

public class AutorIdRequest {

    @NotNull
    private Long id;
}

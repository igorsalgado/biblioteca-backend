package com.project.biblioteca.api.controller;

import com.project.biblioteca.domain.model.Autor;
import com.project.biblioteca.domain.repository.AutorRepository;
import com.project.biblioteca.domain.service.AutorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/autores")
public class AutorController {

    private AutorRepository autorRepository;
    private AutorService autorService;

    @GetMapping
    public List<Autor> listar() {
        return autorRepository.findAll();
    }

    @GetMapping("/{autorId}")
    public ResponseEntity<Autor> buscar(Long autorId) {
        Autor autorListado = autorService.buscarAutor(autorId);
        return ResponseEntity.ok(autorListado);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Autor salvar(@Valid @RequestBody Autor autor) {
        return autorService.salvarAutor(autor);
    }

    @PutMapping("/{autorId}")
    public ResponseEntity<Autor> atualizar(@PathVariable Long autorId, @Valid @RequestBody Autor autor) {
        autor.setId(autorId);
        Autor autorAtualizado = autorService.salvarAutor(autor);
        return ResponseEntity.ok(autorAtualizado);
    }

    @DeleteMapping("/{autorId}")
    public ResponseEntity<Void> excluir(@PathVariable Long autorId) {
        autorService.excluirAutor(autorId);
        return ResponseEntity.noContent().build();
    }

}

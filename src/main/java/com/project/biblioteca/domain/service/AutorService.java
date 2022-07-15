package com.project.biblioteca.domain.service;

import com.project.biblioteca.domain.model.Autor;
import com.project.biblioteca.domain.repository.AutorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class AutorService {

    private AutorRepository autorRepository;

    public Autor buscarAutor(Long autorId) {
        return autorRepository.findById(autorId)
                .orElseThrow(() -> new RuntimeException("Autor não encontrado"));
    }

    @Transactional
    public Autor salvarAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    @Transactional
    public void excluirAutor(Long autorId) {
        autorRepository.deleteById(autorId);
    }


}

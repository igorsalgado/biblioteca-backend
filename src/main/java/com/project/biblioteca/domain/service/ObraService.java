package com.project.biblioteca.domain.service;

import com.project.biblioteca.domain.model.Autor;
import com.project.biblioteca.domain.model.Obra;
import com.project.biblioteca.domain.repository.ObraRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ObraService {

    private ObraRepository obraRepository;
    private AutorService autorService;

    public Obra adicionarObra(Obra obra) {
        Autor autor = autorService.buscarAutor(obra.getAutor().getId());
        obra.setAutor(autor);
        return obraRepository.save(obra);
    }

    @Transactional
    public Obra buscarObra(Long id) {
        return obraRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Obra não encontrada"));
    }

    @Transactional
    public Obra atualizarObra(Obra obra) {
        Autor autor = autorService.buscarAutor(obra.getAutor().getId());
        obra.setAutor(autor);
        return obraRepository.save(obra);
    }

    @Transactional
    public void removerObra(Long id) {
        obraRepository.deleteById(id);
    }
}

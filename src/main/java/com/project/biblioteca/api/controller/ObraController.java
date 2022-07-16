package com.project.biblioteca.api.controller;

import com.project.biblioteca.api.dto.ObraDTO;
import com.project.biblioteca.api.dto.request.ObraRequest;
import com.project.biblioteca.api.mapper.ObraMapper;
import com.project.biblioteca.domain.model.Obra;
import com.project.biblioteca.domain.repository.ObraRepository;
import com.project.biblioteca.domain.service.AutorService;
import com.project.biblioteca.domain.service.ObraService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/obras")
public class ObraController {

    private ObraService obraService;
    private ObraRepository obraRepository;
    private ObraMapper obraMapper;

    @GetMapping("/")
    public List<ObraDTO> listarObras() {
          return obraMapper.toDTO(obraRepository.findAll());
    }


    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ObraDTO salvarObra(@Valid @RequestBody ObraRequest obraRequest) {
        Obra novaObra = obraMapper.toEntity(obraRequest);
        Obra obraSalva = obraService.adicionarObra(novaObra);
        return obraMapper.toDTO(obraSalva);
    }

    @PutMapping("/{obraId}")
    public ResponseEntity<Obra> atualizarObra(@PathVariable Long obraId, @Valid @RequestBody Obra obra) {
        obra.setId(obraId);
        Obra obraAtualizada = obraService.atualizarObra(obra);
        return ResponseEntity.ok(obraAtualizada);
    }

    @DeleteMapping("/{obraId}")
    public ResponseEntity<Void> removerObra(@PathVariable Long obraId) {
        obraService.removerObra(obraId);
        return ResponseEntity.noContent().build();
    }

}

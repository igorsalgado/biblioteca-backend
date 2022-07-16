package com.project.biblioteca.api.mapper;

import com.project.biblioteca.api.dto.ObraDTO;
import com.project.biblioteca.api.dto.request.ObraRequest;
import com.project.biblioteca.domain.model.Obra;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class ObraMapper {

    private ModelMapper modelMapper;

    public ObraDTO toDTO(Obra obra) {
        return modelMapper.map(obra, ObraDTO.class); //indica que o ObraDTO é o destino
    }

    public List<ObraDTO> toDTO(List<Obra> obra) {
        return obra.stream() //indica que o stream vai ser gerado a partir da lista de obras
                .map(this::toDTO) //mapeia cada obra para um dto
                .collect(Collectors.toList()); //converte o stream de dtos em uma lista de dtos
    }

    public Obra toEntity(ObraRequest obraRequest) { //indica que o ObraRequest é o origem
        return modelMapper.map(obraRequest, Obra.class); //indica que o Obra é o destino
    }



}

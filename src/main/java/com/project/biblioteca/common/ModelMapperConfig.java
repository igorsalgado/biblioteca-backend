package com.project.biblioteca.common;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //indica que é uma classe de configuração
public class ModelMapperConfig { //indica que é a configuração de um model mapper
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper(); //cria um modelMapper
    }
}

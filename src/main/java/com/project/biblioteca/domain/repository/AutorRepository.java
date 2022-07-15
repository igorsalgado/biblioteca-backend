package com.project.biblioteca.domain.repository;

import com.project.biblioteca.domain.model.Autor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

    List<Autor> findByNome(String nome);

}

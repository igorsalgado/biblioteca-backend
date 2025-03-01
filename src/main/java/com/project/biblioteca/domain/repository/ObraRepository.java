package com.project.biblioteca.domain.repository;

import com.project.biblioteca.domain.model.Obra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObraRepository extends JpaRepository<Obra, Long> {

}

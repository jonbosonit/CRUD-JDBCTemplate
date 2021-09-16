package com.example.CRUD.JDBCTemplate.persona.infrastructure.repository;

import com.example.CRUD.JDBCTemplate.persona.domain.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonaRepository extends JpaRepository<PersonaEntity,Integer> {
    Optional<PersonaEntity> findById(int id);
    List<PersonaEntity> findByUser(String user);
}

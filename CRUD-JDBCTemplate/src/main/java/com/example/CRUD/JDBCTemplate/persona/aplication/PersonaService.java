package com.example.CRUD.JDBCTemplate.persona.aplication;

import com.example.CRUD.JDBCTemplate.persona.infrastructure.dto.input.PersonaInputDto;
import com.example.CRUD.JDBCTemplate.persona.infrastructure.dto.output.PersonaOutputDto;

import java.util.List;

public interface PersonaService {

    List<PersonaOutputDto> findAllUsernames();
    PersonaOutputDto findById(Integer id);
    PersonaOutputDto save(PersonaInputDto personaInputDto);
    PersonaOutputDto updateById(int id, PersonaInputDto personaInputDto);
    void deleteById(int id);

}

package com.example.CRUD.JDBCTemplate.persona.aplication;

import com.example.CRUD.JDBCTemplate.persona.infrastructure.dto.input.PersonaInputDto;
import com.example.CRUD.JDBCTemplate.persona.infrastructure.dto.output.PersonaOutputDto;

import java.util.List;

public interface PersonaService {
    //PersonaSimpleOutputDto save(PersonaInputDto personaInputDto);
    //List<PersonaOutputDto> findAll();
    //PersonaSimpleOutputDto findById(int id, String type);
    //List<PersonaOutputDto> findByUser(String user);

    //Usando JDBCTemplate
    List<PersonaOutputDto> findAllUsernames();
    PersonaOutputDto findById(Integer id);
    PersonaOutputDto save(PersonaInputDto personaInputDto);
    PersonaOutputDto updateById(int id, PersonaInputDto personaInputDto);
    void deleteById(int id);

    //List<PersonaOutputDto> findByUser(String user);
    //PersonaOutputDto deleteById(int id);
    //PersonaOutputDto updateById(int id, PersonaInputDto personaInputDto);
}

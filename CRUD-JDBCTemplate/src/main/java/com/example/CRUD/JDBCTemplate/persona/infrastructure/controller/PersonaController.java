package com.example.CRUD.JDBCTemplate.persona.infrastructure.controller;

import com.example.CRUD.JDBCTemplate.persona.aplication.PersonaService;
import com.example.CRUD.JDBCTemplate.persona.infrastructure.dto.input.PersonaInputDto;
import com.example.CRUD.JDBCTemplate.persona.infrastructure.dto.output.PersonaOutputDto;
import com.example.CRUD.JDBCTemplate.persona.infrastructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("JDBC/persona")
public class PersonaController {
    @Autowired
    PersonaService personaService;

    @Autowired
    PersonaRepository personaRepository;

    @PostMapping
    public PersonaOutputDto anadirPersona(@RequestBody @Valid PersonaInputDto personaInputDto){
        return personaService.save(personaInputDto);
    }

    @GetMapping("/id/{id}")
    PersonaOutputDto getPersonasById(@PathVariable Integer id){
        return personaService.findById(id);
    }

    @GetMapping("/all")
    List<PersonaOutputDto> findAllUsernames(){
        return personaService.findAllUsernames();
    }

    @PutMapping("/{id}")
    PersonaOutputDto updatePersona(@PathVariable int id, @RequestBody @Valid PersonaInputDto personaInputDto){
        return personaService.updateById(id,personaInputDto);
    }

    @DeleteMapping("/{id}")
    void deletePersonaById(@PathVariable int id){
        personaService.deleteById(id);
    }
}

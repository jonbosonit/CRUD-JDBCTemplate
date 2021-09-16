package com.example.CRUD.JDBCTemplate.persona.infrastructure.dto.output;

import com.example.CRUD.JDBCTemplate.persona.domain.PersonaEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class PersonaSimpleOutputDto {
    Integer id;
    String user;
    String password;
    String surname;
    Date created_date;

    public PersonaSimpleOutputDto(PersonaEntity personaEntity){
        setId(personaEntity.getId());
        setUser(personaEntity.getUser());
        setPassword(personaEntity.getPassword());
        setSurname(personaEntity.getSurname());
        setCreated_date(personaEntity.getCreated_date());
    }
}

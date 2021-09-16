package com.example.CRUD.JDBCTemplate.persona.infrastructure.dto.output;

import com.example.CRUD.JDBCTemplate.persona.domain.PersonaEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
public class PersonaOutputDto extends PersonaSimpleOutputDto{
    public PersonaOutputDto(PersonaEntity personaEntity){
        super(personaEntity);
    }

    public PersonaOutputDto(int id, String user, String password, String surname, Date created_date) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.surname = surname;
        this.created_date = created_date;
    }
}

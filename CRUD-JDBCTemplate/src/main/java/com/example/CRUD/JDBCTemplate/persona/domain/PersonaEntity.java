package com.example.CRUD.JDBCTemplate.persona.domain;

import com.example.CRUD.JDBCTemplate.persona.infrastructure.dto.input.PersonaInputDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "PERSONAENTITY")
@Data
@NoArgsConstructor
public class PersonaEntity {

    @Id
    Integer id;

    @Column
    String user;

    @Column
    String password;

    @Column
    String surname;

    @Column
    Date created_date;

    public void getPersona(PersonaInputDto personaInputDto){
        if(personaInputDto.getId() != null) setId(personaInputDto.getId());
        if(personaInputDto.getUser() != null) setUser(personaInputDto.getUser());
        if(personaInputDto.getPassword() != null) setPassword(personaInputDto.getPassword());
        if(personaInputDto.getSurname() != null) setSurname(personaInputDto.getSurname());
        if(personaInputDto.getCreated_date() != null) setCreated_date(personaInputDto.getCreated_date());
    }

    /*public PersonaEntity(String user,Integer id, String password, Date created_date, String surname){
        this.user = user;
        this.surname = surname;
        this.password = password;
        this.created_date = created_date;
        this.id = id;
    }*/
}

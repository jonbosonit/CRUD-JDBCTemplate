package com.example.CRUD.JDBCTemplate.persona.infrastructure.dto.input;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
@NoArgsConstructor
public class PersonaInputDto {

    @NotNull
    @Id
    Integer id;

    @NotNull(message = "Tu campo created_date no puede ser nulo.")
    @DateTimeFormat
    Date created_date;

    @NotNull(message = "El campo password no puede ser nulo.")
    @Length(min=5, max=20, message = "La contraseña tiene que tener mas de 5 caracteres y menos de 20.")
    String password;

    @NotNull(message = "El campo surname no puede ser nulo.")
    String surname;

    @NotNull(message = "El campo user no puede ser nulo.")
    @Length(min = 6, max = 10, message = "El campo user tiene que tener mas de 6 caracteres y menos de 10.")
    String user;


}

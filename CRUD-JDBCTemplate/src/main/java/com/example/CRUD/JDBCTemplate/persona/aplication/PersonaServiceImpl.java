package com.example.CRUD.JDBCTemplate.persona.aplication;

import com.example.CRUD.JDBCTemplate.exception.ErrorException;
import com.example.CRUD.JDBCTemplate.persona.domain.PersonaEntity;
import com.example.CRUD.JDBCTemplate.persona.infrastructure.dto.input.PersonaInputDto;
import com.example.CRUD.JDBCTemplate.persona.infrastructure.dto.output.PersonaOutputDto;
import com.example.CRUD.JDBCTemplate.persona.infrastructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    private JdbcOperations jdbc;

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Override
    public PersonaOutputDto save(PersonaInputDto personaInputDto) {

        jdbc.update("insert into personaEntity values(?,?,?,?,?)",
                personaInputDto.getId(),
                personaInputDto.getCreated_date(),
                personaInputDto.getPassword(),
                personaInputDto.getSurname(),
                personaInputDto.getUser()
        );
        return jdbc.queryForObject("select * from personaEntity where id=?",new PersonaOutputDtoRowMapper(),personaInputDto.getId());
    }

    public PersonaOutputDto findById(Integer id){
        PersonaOutputDto personaOutputDto;
        personaOutputDto = jdbc.queryForObject("select * from personaEntity where id=?",new PersonaOutputDtoRowMapper(),id);
        return personaOutputDto;
    }

    private class PersonaOutputDtoRowMapper implements RowMapper<PersonaOutputDto>{
        @Override
        public PersonaOutputDto mapRow(ResultSet rs, int rowNum) throws SQLException{
            PersonaOutputDto personaOutputDto;
            personaOutputDto = new PersonaOutputDto(
                    rs.getInt("id"),
                    rs.getString("user"),
                    rs.getString("password"),
                    rs.getString("surname"),
                    rs.getDate("created_date"));

            return personaOutputDto;
        }
    }

    public List<PersonaOutputDto> findAllUsernames(){
        List<PersonaOutputDto> listaPersonaOutputDto;
        listaPersonaOutputDto = jdbc.queryForObject("select * from personaEntity", new PersonaOutputDtoListRowMapper());
        if (listaPersonaOutputDto == null) {
            throw new ErrorException("La lista esta vacia");
        }
        return listaPersonaOutputDto;
    }

    private class PersonaOutputDtoListRowMapper implements RowMapper<List<PersonaOutputDto>>{
        @Override
        public List<PersonaOutputDto> mapRow(ResultSet rs, int rowNum) throws SQLException {
            ArrayList<PersonaOutputDto> listaPersonaOutputDto = new ArrayList();
            do {
                listaPersonaOutputDto.add(new PersonaOutputDto(
                        rs.getInt("id"),
                        rs.getString("user"),
                        rs.getString("password"),
                        rs.getString("surname"),
                        rs.getDate("created_date")));

            }while (rs.next());
            return listaPersonaOutputDto;
        }
    }

    @Override
    public PersonaOutputDto updateById(int id, PersonaInputDto personaInputDto){
        PersonaOutputDto personaOutputDto;
        jdbc.update("update personaEntity set created_date=?, user=?, password=?, surname=? where id=?",
                personaInputDto.getCreated_date(),
                personaInputDto.getUser(),
                personaInputDto.getPassword(),
                personaInputDto.getSurname(),
                id);
        personaOutputDto = jdbc.queryForObject("select * from personaEntity where id=?",new PersonaOutputDtoRowMapper(),id);
        return personaOutputDto;
    }

    @Override
    public  void deleteById(int id){
        PersonaOutputDto personaOutputDto;
        personaOutputDto = jdbc.queryForObject("select * from personaEntity where id=?",new PersonaOutputDtoRowMapper(),id);
        if(personaOutputDto == null) throw  new ErrorException("No existe persona con el id: " + id);
        jdbc.update("delete personaEntity where id=?", id);
    }
}

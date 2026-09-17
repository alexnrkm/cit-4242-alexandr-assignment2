package kz.kimep.moodle_api.dao.repositories;
import kz.kimep.moodle_api.dao.entities.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class PersonRepository {
    private final JdbcTemplate jdbcTemplate;

    public PersonRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Person person){
        String sql = """
                INSERT INTO Person(first, middle, last)
                VALUES(?, ?, ?)
                """;

        jdbcTemplate.update(sql, person.getFirst(), person.getMiddle(), person.getLast());
    }

    public List<Person> findAll(){
        String sql = """
                SELECT * FROM person
                """;

        return jdbcTemplate.query(sql, (resultSet, rowNumber) ->
                new Person(
                        resultSet.getLong("id"),
                        resultSet.getString("first"),
                        resultSet.getString("middle"),
                        resultSet.getString("last")
                ));
    }

    public Person findById(Long id){
        String sql = """
                SELECT * FROM person
                WHERE id = ?""";

        return jdbcTemplate.queryForObject(sql, (resultSet, rowNumber) ->
                new Person(
                        resultSet.getLong("id"),
                        resultSet.getString("first"),
                        resultSet.getString("middle"),
                        resultSet.getString("last")
                ), id);
    }
}

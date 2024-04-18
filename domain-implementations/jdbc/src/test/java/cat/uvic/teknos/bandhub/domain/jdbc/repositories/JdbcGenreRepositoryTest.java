package cat.uvic.teknos.bandhub.domain.jdbc.repositories;

import cat.uvic.teknos.bandhub.domain.jdbc.models.Genre;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class JdbcGenreRepositoryTest {

    @Test
    @DisplayName("Given a new genre (id = 0), when save, then a new record is added to the GENRE table")
    void shouldInsertNewGenreTest() throws SQLException {
        try (var connection = DriverManager.getConnection("jdbc:mysql://localhost/bandhub", "root", null)) {
            Genre genre = new Genre();
            genre.setDescription("Female");

            var repository = new JdbcGenreRepository(connection);
            repository.save(genre);

            assertTrue(genre.getId() > 0);
        }
    }

    @Test
    @DisplayName("Given an existing genre with modified fields, when save, then GENRE table is updated")
    void shouldUpdateAGenreTest() throws SQLException {
        try (var connection = DriverManager.getConnection("jdbc:mysql://localhost/bandhub", "root", null)) {
            Genre genre = new Genre();
            genre.setId(1);
            genre.setDescription("Male");

            var repository = new JdbcGenreRepository(connection);
            repository.save(genre);

            //TODO: test database table updated
            assertTrue(true);
        }
    }

    @Test
    void delete() {
    }

    @Test
    void get() {
    }

    @Test
    void getAll() {
    }
}
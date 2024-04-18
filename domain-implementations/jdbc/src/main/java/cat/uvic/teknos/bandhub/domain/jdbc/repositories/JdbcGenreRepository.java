package cat.uvic.teknos.bandhub.domain.jdbc.repositories;

import cat.uvic.teknos.bandhub.models.Genre;
import cat.uvic.teknos.bandhub.repositories.GenreRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

public class JdbcGenreRepository implements GenreRepository {
    private final Connection connection;

    public JdbcGenreRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Genre model) {
        if (model.getId() <= 0) {
            insert(model);
        } else {
            update(model);
        }
    }

    private void insert(Genre model) {
        try (PreparedStatement statement = connection.prepareStatement("UPDATE GENRE DESCRIPTION = ? WHERE ID = ?", Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, model.getDescription());
            statement.setInt(2, model.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void update(Genre model) {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO GENRE (DESCRIPTION) VALUES (?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, model.getDescription());

            statement.executeUpdate();

            var keys =  statement.getGeneratedKeys();
            if (keys.next()) {
                model.setId(keys.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Genre model) {

    }

    @Override
    public Genre get(Integer id) {
        return null;
    }

    @Override
    public Set<Genre> getAll() {
        return Set.of();
    }
}

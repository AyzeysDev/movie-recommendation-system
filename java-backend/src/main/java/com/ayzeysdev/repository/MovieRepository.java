package com.ayzeysdev.repository;

import com.ayzeysdev.models.Movie;
import com.ayzeysdev.query.QueryStrategy;
import com.ayzeysdev.utils.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class MovieRepository {
    private static final Logger logger = LoggerFactory.getLogger(MovieRepository.class);

    public void addMovie(Movie movie) {
        String query = "INSERT INTO movies (title, genre, actor) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, movie.getTitle());
            stmt.setString(2, movie.getGenre());
            stmt.setString(3, movie.getActor());

            stmt.executeUpdate();
            logger.info("Movie added: {}", movie);
        } catch (SQLException e) {
            logger.error("Error adding movie: {}", movie, e);
        }
    }

    public List<Movie> searchMovies(String input, QueryStrategy strategy) {
        try (Connection conn = ConnectionFactory.getConnection()) {
            return strategy.execute(input, conn);
        } catch (SQLException e) {
            logger.error("Error executing query strategy.", e);
            return List.of();
        }
    }
}
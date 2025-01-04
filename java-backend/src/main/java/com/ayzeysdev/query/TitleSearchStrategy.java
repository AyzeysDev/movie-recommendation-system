package com.ayzeysdev.query;

import com.ayzeysdev.models.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TitleSearchStrategy implements QueryStrategy {
    @Override
    public List<Movie> execute(String title, Connection connection) throws SQLException {
        String query = "SELECT * FROM movies WHERE title ILIKE ?";
        List<Movie> movies = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, "%" + title + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                movies.add(new Movie(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("genre"),
                        rs.getString("actor")
                ));
            }
        }
        return movies;
    }
}

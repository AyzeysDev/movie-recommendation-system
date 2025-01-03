package com.ayzeysdev.query;

import com.ayzeysdev.models.Movie;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface QueryStrategy {
    List<Movie> execute(String input, Connection connection) throws SQLException;
}


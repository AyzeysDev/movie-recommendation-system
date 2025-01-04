package com.ayzeysdev.main;

import com.ayzeysdev.models.Movie;
import com.ayzeysdev.query.TitleSearchStrategy;
import com.ayzeysdev.query.GenreSearchStrategy;
import com.ayzeysdev.repository.MovieRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MovieRepository repository = new MovieRepository();

        // Add sample movies
        repository.addMovie(new Movie(1, "Inception", "Sci-Fi", "Leonardo DiCaprio"));
        repository.addMovie(new Movie(2, "Interstellar", "Sci-Fi", "Matthew McConaughey"));
        repository.addMovie(new Movie(3, "The Dark Knight", "Action", "Christian Bale"));

        // Search by title
        System.out.println("Searching by title 'Inception':");
        List<Movie> titleResults = repository.searchMovies("Inception", new TitleSearchStrategy());
        titleResults.forEach(System.out::println);

        // Search by genre
        System.out.println("\nSearching by genre 'Sci-Fi':");
        List<Movie> genreResults = repository.searchMovies("Sci-Fi", new GenreSearchStrategy());
        genreResults.forEach(System.out::println);
    }
}

package com.ayzeysdev.main;

import com.ayzeysdev.repository.MovieRepository;

public class Main {
    public static void main(String[] args) {
        System.out.println("Movie Recommendation System is running!");
        MovieRepository repository = new MovieRepository();
        repository.logTest(); // Should print: Logging setup is successful!
    }
}
package com.ayzeysdev.models;

public class Movie {
    private final int id;
    private final String title;
    private final String genre;
    private final String actor;

    public Movie(int id, String title, String genre, String actor) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.actor = actor;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getActor() {
        return actor;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", actor='" + actor + '\'' +
                '}';
    }
}

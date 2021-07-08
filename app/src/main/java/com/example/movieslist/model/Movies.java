package com.example.movieslist.model;

import java.io.Serializable;
import java.util.List;

public class Movies implements Serializable {
    private String id;
    private String title;
    private String year;
    private String runtime;
    private List<String> genres;
    private String director;
    private String actors;
    private String plot;
    private String posterUrl;


    public Movies(String id, String title, String year, String runtime, List<String> genres, String director, String actors, String plot, String posterUrl) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.runtime = runtime;
        this.genres = genres;
        this.director = director;
        this.actors = actors;
        this.plot = plot;
        this.posterUrl = posterUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", runtime='" + runtime + '\'' +
                ", genres=" + genres +
                ", director='" + director + '\'' +
                ", actors='" + actors + '\'' +
                ", plot='" + plot + '\'' +
                ", posterUrl='" + posterUrl + '\'' +
                '}';
    }
}

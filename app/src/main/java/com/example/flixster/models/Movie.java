package com.example.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

//this class has defines a movie object
@Parcel
public class Movie {
    String backdropPath;
    String posterPath;
    String title;
    String overview;
    int movieId;
    double popularity;


    // Create an empty constructor for the Parceler library
    public Movie(){}

    // This method receives a json object and initialize the movie variables whit the data from the json response
    public Movie(JSONObject jsonObject) throws JSONException {
        backdropPath = jsonObject.getString("backdrop_path");
        posterPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
        popularity = jsonObject.getDouble("vote_average");
        movieId = jsonObject.getInt("id");
    }

    // Create a list of movies from the json array
    public static List<Movie> moviesFromJsonArray(JSONArray movieJsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < movieJsonArray.length(); i++) {
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;
    }

    // Create getters to generate data from the movie objects


    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w300/%s", backdropPath);
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public double getPopularity() {
        return popularity;
    }

    public int getMovieId() {
        return movieId;
    }
}

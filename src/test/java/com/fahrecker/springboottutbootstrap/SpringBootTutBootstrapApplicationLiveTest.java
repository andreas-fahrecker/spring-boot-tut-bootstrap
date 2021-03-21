package com.fahrecker.springboottutbootstrap;

import com.fahrecker.springboottutbootstrap.persistence.model.Movie;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;
import static org.junit.Assert.assertEquals;

public class SpringBootTutBootstrapApplicationLiveTest {
    private static final String API_ROOT = "http://localhost:8081/api/movies";

    @Test
    public void whenGetAllMovies_thenOK() {
        Response response = RestAssured.get(API_ROOT);

        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    }

    @Test
    public void whenGetMovieByTitle_thenOK() {
        Movie movie = createRandomMovie();
        createMovieAsUri(movie);
        Response response = RestAssured.get(API_ROOT + "/title/" + movie.getTitle());

        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    }

    @Test
    public void whenGetCreatedMovieById_thenOK() {
        Movie movie = createRandomMovie();
        String location = createMovieAsUri(movie);
        Response response = RestAssured.get(location);

        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        assertEquals(movie.getTitle(), response.jsonPath().get("title"));
    }

    @Test
    public void whenGetNotExistsMovieById_thenNotFound() {
        Response response = RestAssured.get(API_ROOT + "/" + randomNumeric(4));

        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
    }

    private Movie createRandomMovie() {
        Movie movie = new Movie();
        movie.setTitle(randomAlphabetic(20));
        movie.setDirector(randomAlphabetic(15));
        return movie;
    }

    private String createMovieAsUri(Movie movie) {
        Response response = RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(movie)
                .post(API_ROOT);
        return API_ROOT + "/" + response.jsonPath().get("id");
    }
}

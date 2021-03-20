package com.fahrecker.springboottutbootstrap.persistence.repo;

import com.fahrecker.springboottutbootstrap.persistence.model.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Long> {
    List<Movie> findByTitle(String title);
}

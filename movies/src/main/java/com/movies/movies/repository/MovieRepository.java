package com.movies.movies.repository;

import com.movies.movies.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository  extends JpaRepository<Movie, Long> {
}

package com.movies.movies.services;

import com.movies.movies.entity.Movie;
import com.movies.movies.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieService {
    private MovieRepository movieRepository;

    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }
}


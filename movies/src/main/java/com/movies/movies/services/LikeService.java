package com.movies.movies.services;

import com.movies.movies.entity.Like;
import com.movies.movies.entity.Movie;
import com.movies.movies.repository.LikeRepository;
import com.movies.movies.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikeService {

    private LikeRepository likeRepository;
    private MovieRepository movieRepository;

    public Like addLike(Long movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new RuntimeException("Movie not found"));

        Optional<Like> existingLike = likeRepository.findByMovieId(movieId);
        Like like;
        if (existingLike.isPresent()) {
            like = existingLike.get();
            like.setCount(like.getCount() + 1);
        } else {
            like = new Like();
            like.setMovie(movie);
            like.setCount(1);
        }

        return likeRepository.save(like);
    }
}

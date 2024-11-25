package com.movies.movies.repository;

import com.movies.movies.entity.Like;
import com.movies.movies.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findByMovieId(Long movieId);

}

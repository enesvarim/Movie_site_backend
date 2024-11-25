package com.movies.movies.services;

import com.movies.movies.entity.Comment;
import com.movies.movies.entity.Like;
import com.movies.movies.entity.Movie;
import com.movies.movies.entity.User;
import com.movies.movies.repository.CommentRepository;
import com.movies.movies.repository.LikeRepository;
import com.movies.movies.repository.MovieRepository;
import com.movies.movies.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final MovieRepository movieRepository;
    private final UserRepository userRepository;

    public CommentService(CommentRepository commentRepository, MovieRepository movieRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.movieRepository = movieRepository;
        this.userRepository = userRepository;
    }

    public List<Comment> getCommentsForMovie(Long movieId) {
        return commentRepository.findByMovieId(movieId);
    }

    public Comment addComment(Long movieId, Long userId, String text) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new RuntimeException("Movie not found"));
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        Comment comment = new Comment();
        comment.setMovie(movie);
        comment.setUser(user);
        comment.setText(text);

        return commentRepository.save(comment);
    }

}

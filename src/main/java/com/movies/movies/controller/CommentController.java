package com.movies.movies.controller;

import com.movies.movies.entity.Comment;
import com.movies.movies.services.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<Comment> addComment(@RequestParam Long movieId, @RequestParam Long userId, @RequestParam String text) {
        Comment newComment = commentService.addComment(movieId, userId, text);
        return ResponseEntity.ok(newComment);
    }

    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<Comment>> getCommentsByMovie(@PathVariable Long movieId) {
        List<Comment> comments = commentService.getCommentsForMovie(movieId);
        return ResponseEntity.ok(comments);
    }

}

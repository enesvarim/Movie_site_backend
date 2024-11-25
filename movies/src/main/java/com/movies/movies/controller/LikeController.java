package com.movies.movies.controller;

import com.movies.movies.entity.Like;
import com.movies.movies.services.LikeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/likes")
public class LikeController {
    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping
    public ResponseEntity<Like> addLike(@RequestParam Long movieId) {
        Like like = likeService.addLike(movieId);
        return ResponseEntity.ok(like);
    }
}

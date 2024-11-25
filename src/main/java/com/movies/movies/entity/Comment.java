package com.movies.movies.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text; // Yorum metni

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Yorum yapan kullanıcı

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie; // Yorum yapılan movie
}

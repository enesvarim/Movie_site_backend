package com.movies.movies.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie; // Beğeni yapılan movie (film)

    private int count = 0; // Beğeni sayısı
}

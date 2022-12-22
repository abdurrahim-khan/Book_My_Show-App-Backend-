package com.example.bookmyshow.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "all_movies")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movie_id;
    @Column(name = "movie_name", nullable = false)
    private String name;
    @Column//(columnDefinition = "DATE", nullable = false)
    private LocalDate releaseDate;

    @OneToMany(mappedBy = "movieEntity", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ShowEntity> listofshows;
}

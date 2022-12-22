package com.example.bookmyshow.model;

import com.example.bookmyshow.enums.TheatreType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "all_theatres")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class TheatreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int theatre_id;

    @Column(name = "theatre_name",nullable = false)
    private String name;

    @Column(name = "theatre_address",nullable = false)
    private String address;

    @Column(name = "theatre_city",nullable = false)
    private String city;

    @Enumerated(EnumType.STRING)
    @Column(name = "theatre_type")
    private TheatreType theatreType;

    @OneToMany(mappedBy = "theatreEntity",cascade = CascadeType.ALL) //bidirectional relationship
    @JsonIgnore
    List<ShowEntity> listofshows;

    @OneToMany(mappedBy = "theatreEntity",cascade = CascadeType.ALL)
    @JsonIgnore
    List<TheatreSeatEntity> listoftheatreseats;
}

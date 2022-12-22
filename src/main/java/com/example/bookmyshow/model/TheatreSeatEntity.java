package com.example.bookmyshow.model;

import com.example.bookmyshow.enums.SeatType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "all_theatre_seats")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class TheatreSeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int theatre_seat_id;

    @Column(name = "theatre_seat_no",nullable = false)
    private String seat_no;

    @Column(name = "theatre_seat_rate",nullable = false)
    private int rate;

    @Enumerated(EnumType.STRING)
    @Column(name = "theatre_seat_type",nullable = false)
    private SeatType seatType;


    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private TheatreEntity theatreEntity;



}

package com.example.bookmyshow.model;

import com.example.bookmyshow.enums.SeatType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@Entity
@Table(name = "all_show_seats")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ShowSeatsEntity { //seats of a show (virtual seat of virtual show)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int show_seats_id;
    @Column(name = "seat_number", nullable = false)
    private String seat_no;
    @Column(name = "seat_rate",nullable = false)
    private int rate;

    @Enumerated(EnumType.STRING)
    @Column(name = "seat_type",nullable = false)
    private SeatType seatType;

    @Column(name = "is_booked")
    private boolean booked;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "seat_booked_at")
    private Date bookedAt;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private TicketEntity ticketEntity;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private ShowEntity showEntity;

}

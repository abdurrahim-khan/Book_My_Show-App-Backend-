package com.example.bookmyshow.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@Entity
@EntityListeners(value = { AuditingEntityListener.class })
@Table(name="all_tickets")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tkt_id;

    @Column(name = "allotted_seats",nullable = false)
    private String allotted_seat;

    @Column(name = "ticket_amount",nullable = false)
    private double amount;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(name = "ticket_booked_at",nullable = false)
    private Date bookedAt;


    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private UserEntity user;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private ShowEntity showEntity;

    @OneToMany(mappedBy = "ticketEntity",cascade = CascadeType.ALL)
    @JsonIgnore
    List<ShowSeatsEntity> listofshowseats;
}

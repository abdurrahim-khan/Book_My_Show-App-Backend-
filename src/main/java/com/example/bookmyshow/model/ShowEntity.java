package com.example.bookmyshow.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@Entity
@EntityListeners(value = { AuditingEntityListener.class })
@Table(name = "all_shows")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int show_id;

    //@Column(columnDefinition = "DATE",nullable = false)
    @Column
    private LocalDate show_date;

    //@Column(columnDefinition = "TIME",nullable = false)
    @Column
    private LocalTime show_time;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "show_creation_date")
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "show_updation_date")
    private Date updatedAt;

    @OneToMany(mappedBy = "showEntity",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<TicketEntity> listoftickets;

    @OneToMany(mappedBy = "showEntity",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ShowSeatsEntity> listofshowseats;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private MovieEntity movieEntity;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private TheatreEntity theatreEntity;

}

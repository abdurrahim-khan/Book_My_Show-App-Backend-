package com.example.bookmyshow.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name="all_users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;

    @Column(name = "user_name",nullable = false)
    private String name;

    @Column(name = "user_mobile",nullable = false)
    private String mobile;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<TicketEntity> listoftickets;
}

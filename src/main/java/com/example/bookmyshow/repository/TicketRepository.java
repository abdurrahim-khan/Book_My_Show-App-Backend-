package com.example.bookmyshow.repository;

import com.example.bookmyshow.model.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketEntity,Integer> {
}

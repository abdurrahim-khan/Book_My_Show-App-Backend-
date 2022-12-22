package com.example.bookmyshow.repository;

import com.example.bookmyshow.model.ShowSeatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowSeatsRepository extends JpaRepository<ShowSeatsEntity,Integer> {
}

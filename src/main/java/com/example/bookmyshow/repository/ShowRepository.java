package com.example.bookmyshow.repository;

import com.example.bookmyshow.model.ShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<ShowEntity,Integer> {
}

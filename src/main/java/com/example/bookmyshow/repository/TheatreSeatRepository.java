package com.example.bookmyshow.repository;

import com.example.bookmyshow.model.TheatreSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreSeatRepository extends JpaRepository<TheatreSeatEntity,Integer> {
}

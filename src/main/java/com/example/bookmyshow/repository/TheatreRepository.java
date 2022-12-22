package com.example.bookmyshow.repository;

import com.example.bookmyshow.model.TheatreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreRepository extends JpaRepository<TheatreEntity,Integer> {
}

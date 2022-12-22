package com.example.bookmyshow.repository;

import com.example.bookmyshow.model.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<MovieEntity,Integer> {
    public boolean existsByName(String name);
}

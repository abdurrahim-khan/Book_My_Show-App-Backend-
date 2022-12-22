package com.example.bookmyshow.repository;

import com.example.bookmyshow.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
}

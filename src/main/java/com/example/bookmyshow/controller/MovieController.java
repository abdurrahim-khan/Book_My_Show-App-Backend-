package com.example.bookmyshow.controller;

import com.example.bookmyshow.dto.entrydto.MovieEntryDto;
import com.example.bookmyshow.dto.responsedto.MovieResponseDto;
import com.example.bookmyshow.service.MovieService;
import com.example.bookmyshow.service.implementation.MovieServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    MovieServiceImp movieServiceImp;
    @GetMapping("/get-movie/{id}")
    public ResponseEntity<MovieResponseDto> getMovie(@PathVariable("id") int id)
    {
        return new ResponseEntity<>(movieServiceImp.getMovie(id), HttpStatus.FOUND);
    }
    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody(required = true) MovieEntryDto movieEntryDto)
    {
        movieServiceImp.addMovie(movieEntryDto);
        return new ResponseEntity<>("movie added successfully",HttpStatus.CREATED);
    }
}

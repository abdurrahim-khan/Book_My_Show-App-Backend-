package com.example.bookmyshow.controller;

import com.example.bookmyshow.dto.entrydto.TheatreEntryDto;
import com.example.bookmyshow.dto.responsedto.TheatreResponseDto;
import com.example.bookmyshow.service.implementation.TheatreServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/theatre")
public class TheatreController {
    @Autowired
    TheatreServiceImp theatreServiceImp;
    @PostMapping("/add-theatre")
    public ResponseEntity<String> addTheatre(@RequestBody(required = true)TheatreEntryDto theatreEntryDto)
    {
        theatreServiceImp.addTheatre(theatreEntryDto);
        return new ResponseEntity<>("theatre added", HttpStatus.CREATED);
    }
    @GetMapping("/get-theatre/{id}")
    public ResponseEntity<TheatreResponseDto> getTheatre(@PathVariable("id") int id)
    {
        return new ResponseEntity<>(theatreServiceImp.getTheatre(id),HttpStatus.FOUND);
    }

}

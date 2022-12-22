package com.example.bookmyshow.controller;

import com.example.bookmyshow.dto.entrydto.ShowEntryDto;
import com.example.bookmyshow.dto.responsedto.ShowResponseDto;
import com.example.bookmyshow.service.ShowService;
import com.example.bookmyshow.service.implementation.ShowServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/show")
public class ShowController {
    @Autowired
    ShowServiceImp showServiceImp;
    @PostMapping("/add-show")
    public ResponseEntity<String> addShow(@RequestBody(required = true)ShowEntryDto showEntryDto)
    {
        showServiceImp.addShow(showEntryDto);
        return new ResponseEntity<>("show added", HttpStatus.CREATED);
    }
    @GetMapping("/get-show/{id}")
    public ResponseEntity<ShowResponseDto> getShow(@PathVariable("id") int id)
    {
        return new ResponseEntity<>(showServiceImp.getShow(id),HttpStatus.FOUND);
    }
}

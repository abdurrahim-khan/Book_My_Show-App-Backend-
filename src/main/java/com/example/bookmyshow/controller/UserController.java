package com.example.bookmyshow.controller;

import com.example.bookmyshow.dto.entrydto.UserEntryDto;
import com.example.bookmyshow.dto.responsedto.UserResponseDto;
import com.example.bookmyshow.service.implementation.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImp userServiceImp;
    @PostMapping("/add-user")
    public ResponseEntity<String> addUser(@RequestBody(required = true)UserEntryDto userEntryDto)
    {
        userServiceImp.addUser(userEntryDto);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }
    @GetMapping("/get-user/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable("id") int id)
    {
        return new ResponseEntity<>(userServiceImp.getUser(id), HttpStatus.FOUND);
    }
}

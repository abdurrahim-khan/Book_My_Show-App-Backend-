package com.example.bookmyshow.service;

import com.example.bookmyshow.dto.entrydto.UserEntryDto;
import com.example.bookmyshow.dto.responsedto.UserResponseDto;

public interface UserService {
    //add user
    public void addUser(UserEntryDto userEntryDto);
    //get user
    public UserResponseDto getUser(int id);
}

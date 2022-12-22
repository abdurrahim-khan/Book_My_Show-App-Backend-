package com.example.bookmyshow.service.implementation;

import com.example.bookmyshow.converter.UserConverter;
import com.example.bookmyshow.dto.entrydto.UserEntryDto;
import com.example.bookmyshow.dto.responsedto.UserResponseDto;
import com.example.bookmyshow.model.UserEntity;
import com.example.bookmyshow.repository.UserRepository;
import com.example.bookmyshow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public void addUser(UserEntryDto userEntryDto) {
        UserEntity userEntity = UserConverter.dtoToEntity(userEntryDto);
        userRepository.save(userEntity);
    }

    @Override
    public UserResponseDto getUser(int id) {
        UserEntity userEntity = userRepository.findById(id).get();
        return UserConverter.entityToDto(userEntity);

    }
}

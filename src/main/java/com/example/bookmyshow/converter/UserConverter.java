package com.example.bookmyshow.converter;

import com.example.bookmyshow.dto.entrydto.UserEntryDto;
import com.example.bookmyshow.dto.responsedto.UserResponseDto;
import com.example.bookmyshow.model.UserEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserConverter {
    public static UserEntity dtoToEntity(UserEntryDto userEntryDto)
    {
        return UserEntity.builder().name(userEntryDto.getName()).mobile(userEntryDto.getMobile()).build();
    }
    public static UserResponseDto entityToDto(UserEntity userEntity)
    {
        return UserResponseDto.builder().id(userEntity.getUser_id()).name(userEntity.getName()).mobile(userEntity.getMobile()).build();
    }
}

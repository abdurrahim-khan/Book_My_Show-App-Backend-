package com.example.bookmyshow.service.implementation;

import com.example.bookmyshow.converter.MovieConverter;
import com.example.bookmyshow.dto.entrydto.MovieEntryDto;
import com.example.bookmyshow.dto.responsedto.MovieResponseDto;
import com.example.bookmyshow.model.MovieEntity;
import com.example.bookmyshow.repository.MovieRepository;
import com.example.bookmyshow.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class MovieServiceImp implements MovieService {
    @Autowired
    MovieRepository movieRepository;
    @Override
    public void addMovie(MovieEntryDto movieEntryDto) {
        if(!movieRepository.existsByName(movieEntryDto.getName()))
        {
            MovieEntity movieEntity = MovieConverter.dtoToEntity(movieEntryDto);
            movieRepository.save(movieEntity);
        }
        else {
            log.info("movie already exists");
        }
    }

    @Override
    public MovieResponseDto getMovie(int id) {
        MovieEntity movieEntity = movieRepository.findById(id).get();
        return MovieConverter.entityToDto(movieEntity);
    }
}

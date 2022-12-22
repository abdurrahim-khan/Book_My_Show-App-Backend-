package com.example.bookmyshow.service.implementation;

import com.example.bookmyshow.converter.TicketConverter;
import com.example.bookmyshow.dto.entrydto.BookingRequestDto;
import com.example.bookmyshow.dto.responsedto.TicketDto;
import com.example.bookmyshow.model.ShowEntity;
import com.example.bookmyshow.model.ShowSeatsEntity;
import com.example.bookmyshow.model.TicketEntity;
import com.example.bookmyshow.model.UserEntity;
import com.example.bookmyshow.repository.ShowRepository;
import com.example.bookmyshow.repository.TicketRepository;
import com.example.bookmyshow.repository.UserRepository;
import com.example.bookmyshow.service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class TicketServiceImp implements TicketService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ShowRepository showRepository;
    @Autowired
    TicketRepository ticketRepository;

    @Override
    public TicketDto bookTicket(BookingRequestDto bookingRequestDto) throws Exception {
        UserEntity userEntity = userRepository.findById(bookingRequestDto.getUser_id()).get();
        ShowEntity showEntity = showRepository.findById(bookingRequestDto.getShow_id()).get();
        Set<String> requestedSeats = bookingRequestDto.getRequestedSeats();

        List<ShowSeatsEntity> showSeatsEntityList = showEntity.getListofshowseats();

        Set<String> allottedSeats_Set = new HashSet<>();
        List<ShowSeatsEntity> bookedSeats = new ArrayList<>();
        for(String seatrequested : requestedSeats)
        {
            for(ShowSeatsEntity showSeat : showSeatsEntityList)
            {
                if(showSeat.getSeat_no().equals(seatrequested) && showSeat.isBooked() == false)
                {
                    allottedSeats_Set.add(seatrequested);
                }
            }
        }
        TicketEntity ticketEntity = null;
        if(allottedSeats_Set.size() != requestedSeats.size())
        {
            log.error("book again seat already booked");
            throw new Exception("seats could not be booked");
        }
        else {
            double amount = 0.0;
            String allottedSeats = "";
            for(ShowSeatsEntity showseats : showSeatsEntityList)
            {
                if(allottedSeats_Set.contains(showseats.getSeat_no()))
                {
                    bookedSeats.add(showseats);
                    allottedSeats = allottedSeats + showseats.getSeat_no()+" ";
                    amount += showseats.getRate();

                }
            }
            ticketEntity = TicketEntity.builder().bookedAt(new Date()).showEntity(showEntity).allotted_seat(allottedSeats).user(userEntity).amount(amount).listofshowseats(bookedSeats).build();

            userEntity.getListoftickets().add(ticketEntity);
            showEntity.getListoftickets().add(ticketEntity);

            for(ShowSeatsEntity seats : bookedSeats)
            {
                seats.setTicketEntity(ticketEntity);
                seats.setBookedAt(new Date());
                seats.setBooked(true);
            }
            ticketRepository.save(ticketEntity);
        }
        return TicketConverter.entityToDto(ticketEntity);
    }

    @Override
    public TicketDto getTicket(int id) {
        TicketEntity ticketEntity = ticketRepository.findById(id).get();
        return TicketConverter.entityToDto(ticketEntity);
    }

}

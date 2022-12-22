package com.example.bookmyshow.controller;

import com.example.bookmyshow.dto.entrydto.BookingRequestDto;
import com.example.bookmyshow.dto.responsedto.TicketDto;
import com.example.bookmyshow.service.implementation.TicketServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    TicketServiceImp ticketServiceImp;
    @PostMapping("/book-ticket")
    public ResponseEntity<TicketDto> bookTicket(@RequestBody(required = true)BookingRequestDto bookingRequestDto)
    {
        TicketDto ticketDto = null;
        try
        {
            ticketDto = ticketServiceImp.bookTicket(bookingRequestDto);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(ticketDto,HttpStatus.CREATED);
    }
    @GetMapping("/get-ticket/{id}")
    public ResponseEntity<TicketDto> getTicket(@PathVariable("id") int id)
    {
        return new ResponseEntity<>(ticketServiceImp.getTicket(id),HttpStatus.FOUND);
    }
}

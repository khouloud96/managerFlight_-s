/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.microservices.TicketService.controller;

import com.microservices.TicketService.dto.BookingDto;
import com.microservices.TicketService.entities.Booking;
import com.microservices.TicketService.service.BookingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DELL
 */
@RestController
@RequestMapping( "/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;
    
    @GetMapping
    public List<BookingDto> getBookings() {
        return bookingService.getBookings();
    }

    @GetMapping("/{id}")
    public BookingDto getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }
    
    @GetMapping("/{passenger}")
    public Booking getBookingById(@PathVariable String idPassenger) {
        return bookingService.getBookingByPassenger(idPassenger);
    }

    @PostMapping
    public BookingDto addPassenger(BookingDto bookingDto) {
        return bookingService.addBooking(bookingDto);
    }

    @DeleteMapping("/{id}")
    public void deletePassenger(@PathVariable Long id) {
        bookingService.cancelBooking(id);
    }
}



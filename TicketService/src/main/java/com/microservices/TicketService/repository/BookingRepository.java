/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.microservices.TicketService.repository;

import com.microservices.TicketService.entities.Booking;
import com.microservices.TicketService.entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DELL
 */
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    public Booking findByPassenger(Passenger passenger);
}

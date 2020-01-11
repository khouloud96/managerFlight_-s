/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.microservices.controller;

import com.microservices.dto.PassengerDtO;
import com.microservices.service.PassengerService;
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
@RequestMapping( "/passengers")
public class PassengerController {
    @Autowired
    private PassengerService passengerService;
    
    @GetMapping
    public List<PassengerDtO> getPassengers() {
        return passengerService.getPassengers();
    }

    @GetMapping("/{id}")
    public PassengerDtO getPassengerById(@PathVariable String id) {
        return passengerService.getPassengerById(id);
    }

    @PostMapping
    public PassengerDtO addPassenger(PassengerDtO passengerDto) {
        return passengerService.addPassenger(passengerDto);
    }

    @DeleteMapping("/{id}")
    public void deletePassenger(@PathVariable String id) {
        passengerService.deletePassenger(id);
    }
 
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.microservices.controller;

import com.microservices.entities.Client;
import com.microservices.entities.Passenger;
import com.microservices.repository.PassengerRepository;
import com.microservices.service.ClientService;
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
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;
    
    @Autowired
    private PassengerRepository passengerRepository;
    
    @GetMapping
    public List<Client> getClients() {
        return clientService.getClients();
    }

    @GetMapping("/{username}")
    public Client getClientByUsername(@PathVariable String id) {
        return clientService.getClientById(id);
    }
    
    @PostMapping("/id")
    public Passenger saveClient(@PathVariable String id, String username, String mdp){
        Passenger passenger = passengerRepository.findById(id).get();
        Client client = new Client(passenger, username, mdp);
        //passenger.setUsername(username);
        //passenger.setMdp(mdp);
        return clientService.saveClient(client);
    }

    @DeleteMapping("/{username}")
    public void deleteClient(@PathVariable String id) {
        clientService.deleteClient(id);
    }
    
}

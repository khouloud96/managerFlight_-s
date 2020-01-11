/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.microservices.service;

import com.microservices.entities.Client;
import com.microservices.entities.Passenger;
import com.microservices.repository.ClientRepository;
import com.microservices.repository.PassengerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private PassengerRepository passengerRepository;
   
    public List<Client> getClients() {
        return this.clientRepository.findAll();
    }

    public Client getClientById(String id) {
        return clientRepository.findById(id).get();
    }
    
    public Passenger saveClient(Client client) {
        Passenger p = passengerRepository.findById(client.getNumPassport()).get();
        return passengerRepository.save(p);
    }
    
    public void deleteClient(String id) {
        Client client = clientRepository.findById(id).get();

        clientRepository.delete(client);
    }
}

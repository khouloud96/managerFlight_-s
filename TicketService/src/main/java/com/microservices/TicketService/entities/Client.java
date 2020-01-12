/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.microservices.TicketService.entities;

import javax.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author DELL
 */
@Data
@NoArgsConstructor
@Entity
public class Client extends Passenger {
    private String Username;
    
    private String mdp;
    
    public Client(Passenger passenger, String username, String mdp){
        this.Username = username;
        this.mdp = mdp;
        this.setNumPassport(passenger.getNumPassport());
        this.setAge(passenger.getAge());
        this.setEmail(passenger.getEmail());
        this.setFirstName(passenger.getFirstName());
        this.setLastName(passenger.getLastName());
    }
}

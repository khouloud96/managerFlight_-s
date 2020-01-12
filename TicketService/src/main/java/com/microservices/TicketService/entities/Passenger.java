/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.microservices.TicketService.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *
 * @author DELL
 */
@Data
@NoArgsConstructor
@Entity
public class Passenger {
    @Id
    private String NumPassport;
    
    private String FirstName;
    
    private String LastName;
    
    private String sexe;
    
    private int age;
    
    private String email;
    
    @OneToMany(mappedBy = "passenger", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Booking> booking;
    
    public Passenger(String NumPassport, String firstName, String lastName, String sexe, int age, String email){
        this.NumPassport = NumPassport;
        this.FirstName = firstName;
        this.LastName = lastName;
        this.sexe = sexe;
        this.age = age;
        this.email = email;
    }
    
}

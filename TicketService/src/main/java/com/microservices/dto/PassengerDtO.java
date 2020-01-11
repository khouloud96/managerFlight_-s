/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.microservices.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author DELL
 */
@Getter
@Setter
@NoArgsConstructor
public class PassengerDtO {
    private String NumPassport;
    
    private String FirstName;
    
    private String LastName;
    
    private String sexe;
    
    private int age;
    
    private String email;
    
    public PassengerDtO(String NumPassport, String firstName, String lastName, String sexe, String email, int age){
        this.NumPassport = NumPassport;
        this.FirstName = firstName;
        this.LastName = lastName;
        this.sexe = sexe;
        this.age = age;
        this.email = email;
    }
    
}

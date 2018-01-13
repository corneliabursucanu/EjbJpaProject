/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cornelia.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author cornelia
 */

@Entity
@Table
@NamedQueries(@NamedQuery(name="Client.getAll", query="SELECT e from Client e"))

public class Client implements Serializable { 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    private int clientId;
    @Column
    private String firstname;
    @Column
    private String lastname;
    @Column
    private int flightId;

    public Client(int clientId, String firstname, String lastname, int flightId) {
        this.clientId = clientId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.flightId = flightId;
    }
    
    public Client(){
    
    }
    
    

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    @Override
    public String toString() {
        return "Client{" + "clientId=" + clientId + ", firstname=" + firstname + ", lastname=" + lastname + ", flightId=" + flightId + '}';
    }
    
    
}

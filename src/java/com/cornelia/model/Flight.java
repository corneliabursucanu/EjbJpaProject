/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cornelia.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author cornelia
 */


@Entity
@Table
@NamedQueries(@NamedQuery(name="Flight.getAll", query="SELECT f from Flight f"))

public class Flight implements Serializable {
    @Id
    @Column(name="flightId")
    private Integer flightId;
    @Column
    private String origin;
    @Column
    private String destination;
    
   
    

    public Flight() {
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Flight(Integer flightId, String orgin, String destination) {
        this.flightId = flightId;
        this.origin = orgin;
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Flight{" + "flightId=" + flightId + ", origin=" + origin + ", destination=" + destination + '}';
    }
    
    
    
    
    
}

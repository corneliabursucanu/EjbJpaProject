/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cornelia.dao;

import com.cornelia.model.Flight;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cornelia
 */
@Stateless
@LocalBean
public class FlightDao {
    
    
    @PersistenceContext
    private EntityManager em;
    
    public List<Flight> getAllFlights() {
        return em.createNamedQuery("Flight.getAll").getResultList() ;
    }

    
}

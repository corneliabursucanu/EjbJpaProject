/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cornelia.dao;

import com.cornelia.model.Client;
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
public class ClientDAO{

    @PersistenceContext
    private EntityManager em;
    
    
    
    public void addClient(Client client) {
        em.persist(client);
    }

    
    public void editClient(Client client) {
        em.merge(client);
    }

    
    public void deleteClient(int clientId) {
        em.remove(getClient(clientId));
    }

    
    public Client getClient(int clientId) {
       return em.find(Client.class, clientId);
    }

    
    public List<Client> getAllClients() {
        return em.createNamedQuery("Client.getAll").getResultList();
    }
    
    

 
}

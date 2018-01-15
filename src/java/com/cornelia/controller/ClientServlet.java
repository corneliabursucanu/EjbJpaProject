/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cornelia.controller;

import com.cornelia.dao.ClientDAO;
import com.cornelia.dao.FlightDao;
import com.cornelia.model.Client;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cornelia
 */
@WebServlet(name = "ClientServlet", urlPatterns = {"/ClientServlet"})
public class ClientServlet extends HttpServlet {
@EJB
private ClientDAO clientDao;

@EJB
private FlightDao flightDao;
  
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        request.setAttribute("allClients", clientDao.getAllClients());
        request.setAttribute("allFlightsfromServlet", flightDao.getAllFlights());
        
        request.getRequestDispatcher("clientInfo.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String clientIdStr = request.getParameter("clientId");
        int clientId = 0;
        if(clientIdStr!=null && !clientIdStr.equals(""))
            clientId=Integer.parseInt(clientIdStr);
       
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String flightIdStr = request.getParameter("flightId");
        int flightId=0 ;
        if(flightIdStr!=null && !flightIdStr.equals(""))
            flightId=Integer.parseInt(flightIdStr);
        
        Client client = new Client(clientId, firstname, lastname, flightId);
        
        if("Add".equalsIgnoreCase(action)) {
            clientDao.addClient(client);      
        }else if ("Edit".equalsIgnoreCase(action)) {
            clientDao.editClient(client);
        }else if ("Delete".equalsIgnoreCase(action)) {
            clientDao.deleteClient(clientId);
        }else if ("Search".equalsIgnoreCase(action))
           client = clientDao.getClient(clientId);
        
        request.setAttribute("client", client);
        request.setAttribute("allClients", clientDao.getAllClients());
        request.setAttribute("allFlightsfromServlet", flightDao.getAllFlights());
        request.getRequestDispatcher("clientInfo.jsp").forward(request, response);
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    }

    



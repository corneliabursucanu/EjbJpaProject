/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cornelia.controller;

import com.cornelia.dao.FlightDao;
import com.cornelia.model.Flight;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cornelia
 */
@WebServlet(name = "FlightsServlet", urlPatterns = {"/FlightsServlet"})
public class FlightsServlet extends HttpServlet {

    
   
   private FlightDao fdao = null;
    

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    
    try {
	Context context = new InitialContext();
        Object obj = context.lookup("java:global/EjbJpaProject/FlightDao!com.cornelia.dao.FlightDao");
	fdao = (FlightDao) obj ;
			
			
			
        }catch(NamingException e) {
            System.out.println("Problema cu JNDI");
            e.printStackTrace();
			
		}
		
		if (fdao!=null)
			System.out.println("OK JNDI");
                
          request.setAttribute("allFlights", fdao.getAllFlights());
        
        request.getRequestDispatcher("flightsInfo.jsp").forward(request, response);
    
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
    }

    
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

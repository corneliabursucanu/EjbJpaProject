<%-- 
    Document   : flightsInfo
    Created on : Jan 14, 2018, 12:22:05 AM
    Author     : cornelia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fligts Details</title>
    </head>
    <body>
        <h1> Flights details </h1>
        <table border="1">
            <th>FlightID</th>
            <th>Origin</th>
            <th>Destination</th>
           
            <c:forEach items="${allFlights}" var="flights">
                <tr>
                    <td>${flights.flightId}</td>
                    <td>${flights.origin}</td>
                    <td>${flights.destination}</td>
                   
                </tr>
            </c:forEach>
        
        
        </table>
    </body>
</html>

<%-- 
    Document   : clientInfo
    Created on : Jan 6, 2018, 3:35:51 PM
    Author     : cornelia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Client Information</title>
    </head>
    <body>
        <h1>Client Information</h1>
        <form action="./ClientServlet" method="POST">
        <table>
            <tr>
                <td>Client ID </td>
                <td> <input type="text" name="clientId" value="${client.clientId}" /> </td>
            </tr>
            
             <tr>
                <td>First Name</td>
                <td> <input type="text" name="firstname" value="${client.firstname}" /> </td>
            </tr>
            
             <tr>
                <td>Last Name</td>
                <td> <input type="text" name="lastname" value="${client.lastname}" /></td>
            </tr>
            
             <tr>
                <td>Flight Id</td>
                <td> <input type="text" name="flightId" value="${client.flightId}" /> </td>
            </tr>
            
            <tr>
                <td colspan="2">
                    <input type="submit" name ="action" value ="Add" />
                    <input type="submit" name ="action" value ="Edit" />
                    <input type="submit" name ="action" value ="Delete" />
                    <input type="submit" name ="action" value ="Search" />
                </td>
            </tr>   
        </table>
        </form>
        <br>
        
        <table border="1">
            <th>ClientID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>FlightId</th>
            <c:forEach items="${allClients}" var="cl">
                <tr>
                    <td>${cl.clientId}</td>
                    <td>${cl.firstname}</td>
                    <td>${cl.lastname}</td>
                    <td>${cl.flightId}</td>
                </tr>
            </c:forEach>
        
        
        </table>
    </body>
</html>

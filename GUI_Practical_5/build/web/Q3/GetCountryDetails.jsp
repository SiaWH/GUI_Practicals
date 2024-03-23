<%-- 
    Document   : GetCountryDetails
    Created on : 19 Mar 2024, 10:15:30 PM
    Author     : admin
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Country Details</title>
    </head>
    <body>
        <h1>Confirmation</h1>
        <h3>Are you sure to add this country?</h3>
        <%
            String name = request.getParameter("name").trim();
            String officialName = request.getParameter("officialName").trim();
            String capital = request.getParameter("capital").trim();
        %>

        <p>County Name: <%=name %></p>
        <p>Official Name: <%=officialName %></p>
        <p>Capital: <%=capital %></p>
        
        <form action="SaveCountryDetails.jsp" method="post">
            <input type="hidden" name="name" value="<%= name %>">
            <input type="hidden" name="officialName" value="<%= officialName %>">
            <input type="hidden" name="capital" value="<%= capital %>"><br>
            <input type="submit" value="Confirm">
        </form>
        <br>
        <form action="AddCountry.html" method="get">
            <input type="submit" value="Cancel">
        </form>
    </body>
</html>

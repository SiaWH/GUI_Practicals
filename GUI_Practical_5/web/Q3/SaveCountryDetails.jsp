<%-- 
    Document   : SaveCountryDetails
    Created on : 19 Mar 2024, 10:16:23 PM
    Author     : admin
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="domain.Country, da.CountriesDA" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Save Country Details</title>
    </head>
    <body>
        <%
            String name = request.getParameter("name").trim();
            String officialName = request.getParameter("officialName").trim();
            String capital = request.getParameter("capital").trim();

            Country country = new Country(name, officialName, capital);
            CountriesDA countriesDA = new CountriesDA();
            
            if (countriesDA.addRecord(country)) {
                out.println("<h1>Country details saved successfully!</h1>");
            } else {
                out.println("<h1>Failed to save country details...</h1>");
            }
        %>
    </body>
</html>

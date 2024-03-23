<%-- 
    Document   : BMICalculation
    Created on : 19 Mar 2024, 8:52:20 PM
    Author     : admin
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="domain.BMI" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BMI Calculation</title>
    </head>
    <body>
        <h1>BMI Calculation</h1>
        <%
            BMI bmi = new BMI(Double.parseDouble(request.getParameter("weight")), 
                                Double.parseDouble(request.getParameter("height")));

            String bmiValue = String.format("%.2f", bmi.getBMI());

        %>
        <p>Height: <%=bmi.getHeight() %> m</p>
        <p>Weight: <%=bmi.getWeight() %> kg</p>
        <p>BMI: <%=bmiValue %></p>
        <p>Category: <%=bmi.getStatus() %></p>
    </body>
</html>

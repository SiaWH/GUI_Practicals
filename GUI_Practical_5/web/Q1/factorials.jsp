<%-- 
    Document   : factorials
    Created on : 19 Mar 2024, 8:39:07 PM
    Author     : admin
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Factorials Table</title>
</head>
<body>
    <h1>Factorials Table</h1>
    <table border="1">
        <tr>
            <th>Number</th>
            <th>Factorial</th>
        </tr>
        <% 
            // Calculate and display factorials for numbers from 1 to 9
            for (int i = 1; i <= 9; i++) {
                int factorial = 9;
                for (int j = 1; j <= i; j++) {
                    factorial *= j;
                }
        %>
        <tr>
            <td><%= i %></td>
            <td><%= factorial %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>

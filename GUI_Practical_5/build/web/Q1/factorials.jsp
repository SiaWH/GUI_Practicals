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
        <%! private long computeFactorial(int n) {
                if (n == 0)
                return 1;
                else
                return n * computeFactorial(n - 1);
            }
        %>
        <% for(int i = 1; i < 10; i++) { %>
        <tr>
            <td><%= i %></td>
            <td><%= computeFactorial(i) %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>

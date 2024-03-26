/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import domain.Loan;

/**
 *
 * @author admin
 */
public class LoanDetails extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoanDetails</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoanDetails at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        double amount = Double.parseDouble(request.getParameter("amount"));
        double rate = Double.parseDouble(request.getParameter("rate"));
        int year = Integer.parseInt(request.getParameter("year"));
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>localhost</title>");            
        out.println("</head>");
        out.println("<body>");
        
        out.println("<p>You entered the following data</p><br>");
        out.println("<p>Loan amount: RM" + String.format("%.2f", amount) + "</p>");
        out.println("<p>Annual interest rate: " + String.format("%.2f", rate) + "</p>");
        out.println("<p>Number of year: " + year + "</p><br>");
        
        out.println("<form method=\"post\" action=\"LoanDetails\" >");
        out.println("<input type=\"hidden\" name=\"amount\" value=\""+ amount + "\">");
        out.println("<input type=\"hidden\" name=\"rate\" id=\"rate\" value=\""+ rate + "\">");
        out.println("<input type=\"hidden\" name=\"year\" id=\"year\" value=\""+ year + "\">");
        out.println("<input type=\"submit\" value=\"Confirm\">");
        out.println("</form>");
        
        out.println("</body>");
        out.println("</html>");
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        double amount = Double.parseDouble(request.getParameter("amount"));
        double rate = Double.parseDouble(request.getParameter("rate"));
        int year = Integer.parseInt(request.getParameter("year"));
        
        Loan loan = new Loan(rate, year, amount);
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>localhost</title>");            
        out.println("</head>");
        out.println("<body>");
        
        out.println("<p>Loan amount: RM" + String.format("%.2f", amount) + "</p>");
        out.println("<p>Annual interest rate: " + String.format("%.2f", rate) + "</p>");
        out.println("<p>Number of year: " + year + "</p>");
        out.println("<p>Monthly Payment: RM<b>" + String.format("%.2f", loan.getMonthlyPayment()) + "</b></p>");
        out.println("<p>Total Payment: RM<b>" + String.format("%.2f", loan.getTotalPayment()) + "</b></p>");
        
        out.println("</body>");
        out.println("</html>");
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

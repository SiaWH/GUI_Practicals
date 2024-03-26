/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import da.*;
import domain.*;

/**
 *
 * @author admin
 */
public class StudentDetails extends HttpServlet {

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
            out.println("<title>Servlet StudentDetails</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StudentDetails at " + request.getContextPath() + "</h1>");
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
        PrintWriter out = response.getWriter();

        String id = request.getParameter("id");
        String ic = request.getParameter("ic");
        String name = request.getParameter("name");
        String level = request.getParameter("level");
        String programme = request.getParameter("programme");
        String yearOfStudy = request.getParameter("yearOfStudy");
        
        Cookie nameCookie = new Cookie("name", name);
        response.addCookie(nameCookie);

        out.println("<html><head><title>localhost</title></head><body>");
        out.println("<p>Student ID: <b>" + id + "</b></p>");
        out.println("<p>IC Number: <b>" + ic + "</b></p>");
        out.println("<p>Name: <b>" + name + "</b></p>");
        out.println("<p>Level: <b>" + level + "</b></p>");
        out.println("<p>Programme: <b>" + programme + "</b></p>");
        out.println("<p>Year of Study: <b>" + yearOfStudy + "</b></p>");
        out.println("<a href=\"CookiesServlet\">Click here</a>");
        out.println("</body></html>");

        out.close();
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
        ProgrammeDA programmeDa = new ProgrammeDA();
        StudentDA studentDa = new StudentDA();

        String id = request.getParameter("id");
        String ic = request.getParameter("ic");
        String name = request.getParameter("name");
        char level = request.getParameter("level").charAt(0);
        String programmeId = request.getParameter("programme");
        int yearOfStudy = Integer.parseInt(request.getParameter("yearOfStudy"));
        Programme programme = programmeDa.getRecord(programmeId);

        Student newStudent = new Student(id, ic, name, level, programme, yearOfStudy);

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>localhost</title>");
        out.println("</head>");
        out.println("<body>");
        if (studentDa.addRecord(newStudent)) {
            out.println("<p>Student <b>" + id + "</b> has been added to the database</p>");
        } else {
            out.println("<p>Student <b>" + id + "</b> is failed to add to the database</p>");
        }
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

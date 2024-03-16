package gui_practical_4;

import java.sql.*;
import javax.swing.*;

public class ProgrammeDA {
    private String host = "jdbc:derby://localhost:1527/collegedb2";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "Programme";
    private Connection conn;
    private PreparedStatement stmt;
    
    public ProgrammeDA() {
        createConnection();
    }
    
    public boolean createRecord(Programme programme) {
        String queryStr = "INSERT INTO " + tableName + " VALUES(?, ?, ?)";
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, programme.getCode());
            stmt.setString(2, programme.getName());
            stmt.setString(3, programme.getFaculty());
            
            return stmt.executeUpdate() == 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public Programme getRecord(String code) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE Code = ?";
        Programme programme = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, code);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                programme = new Programme(code, rs.getString("Name"), rs.getString("Faculty"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return programme;
    }
    
    public boolean updateRecord(Programme programme) {
        String queryStr = "UPDATE " + tableName + " SET Faculty = ?, Name = ? WHERE Code = '" + programme.getCode()+"'";
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, programme.getFaculty());
            stmt.setString(2, programme.getName());
            
            return stmt.executeUpdate() == 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public boolean deleteRecord(String code) {
        String queryStr = "DELETE FROM " + tableName + " WHERE Code = ?";
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, code);
            return stmt.executeUpdate() == 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
        
    private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
            System.out.println("***TRACE: Connection established.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void shutDown() {
        if (conn != null)
            try {
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}

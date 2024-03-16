package gui_practical_4;

import java.sql.*;
import javax.swing.*;

public class StudentDA {
    private String host = "jdbc:derby://localhost:1527/collegedb2";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "Student";
    private Connection conn;
    private PreparedStatement stmt;
    
    public StudentDA() {
        createConnection();
    }
    
    public Student getRecordById(String id) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE Id = ?";
        Student student = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                String levelStr = rs.getString("Level");
                char levelChar = levelStr.charAt(0);
                Programme programme = new MaintainProgrammeControl().selectRecord(rs.getString("Programmecode"));
                student = new Student(id, rs.getString("Ic"), rs.getString("Name"), levelChar, programme, rs.getInt("Yr"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return student;
    }
    
    public Student getRecordByIc(String ic) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE Ic = ?";
        Student student = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, ic);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                String levelStr = rs.getString("Level");
                char levelChar = levelStr.charAt(0);
                Programme programme = new MaintainProgrammeControl().selectRecord(rs.getString("Programmecode"));
                student = new Student(rs.getString("Id"), ic, rs.getString("Name"), levelChar, programme, rs.getInt("Yr"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return student;
    }
    
    public boolean createRecord(Student student) {
        String queryStr = "INSERT INTO " + tableName + " VALUES(?, ?, ?, ?, ?, ?)";
        Programme programme = student.getProgramme();
        String programmeCode = programme.getCode();
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, student.getId());
            stmt.setString(2, student.getIc());
            stmt.setString(3, student.getName());
            stmt.setString(4, Character.toString(student.getLevel()));
            stmt.setString(5, programmeCode);
            stmt.setInt(6, student.getYear());
            
            return stmt.executeUpdate() == 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public boolean updateRecord(Student student) {
        String queryStr = "UPDATE " + tableName + " SET Ic = ?, Name = ?, Level = ?, Programmecode = ?, Yr = ? WHERE Id = " + student.getIc();
        Programme programme = student.getProgramme();
        String programmeCode = programme.getCode();
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, student.getIc());
            stmt.setString(2, student.getName());
            stmt.setString(3, Character.toString(student.getLevel()));
            stmt.setString(4, programmeCode);
            stmt.setInt(5, student.getYear());
            
            return stmt.executeUpdate() == 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public boolean deleteRecord(String id) {
        String queryStr = "DELETE FROM " + tableName + " WHERE Id = ?";
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, id);
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

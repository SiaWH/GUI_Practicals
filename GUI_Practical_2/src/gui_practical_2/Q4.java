/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_practical_2;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Q4 extends JFrame {

    private final ArrayList<String> studentList = new ArrayList<>();

    public Q4() {
        studentList.add("qwer");
        setTitle("Maintain Students");
        setSize(400, 80);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        JButton createButton = new JButton("Create");
        JButton retrieveButton = new JButton("Retrieve");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(createButton);
        buttonPanel.add(retrieveButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        add(buttonPanel);

        createButton.addActionListener(new CreateListener());
        retrieveButton.addActionListener(new RetrieveListener());
        updateButton.addActionListener(new UpdateListener());
        deleteButton.addActionListener(new DeleteListener());
    }

    class CreateListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String studentName = JOptionPane.showInputDialog("Enter student name:");
            studentList.add(studentName);
            displayStudentList();
        }
    }

    class RetrieveListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            displayStudentList();
        }
    }

    class UpdateListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String oldName = JOptionPane.showInputDialog("Enter student name to update:");
            if (studentList.contains(oldName)) {

                String newName = JOptionPane.showInputDialog("Enter new student name:");
                int index = studentList.indexOf(oldName);
                studentList.set(index, newName);
                displayStudentList();
            } else {
                JOptionPane.showMessageDialog(null, "Student not found!");
            }
        }
    }

    class DeleteListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String studentName = JOptionPane.showInputDialog("Enter student name to delete:");
            if (studentList.contains(studentName)) {
                studentList.remove(studentName);
                displayStudentList();
            } else {
                JOptionPane.showMessageDialog(null, "Student not found!");
            }
        }
    }

    private void displayStudentList() {
        StringBuilder sb = new StringBuilder("Student List:\n");
        for (String student : studentList) {
            sb.append(student).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    // Main method
    public static void main(String[] args) {
        new Q4();
    }
}

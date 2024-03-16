/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_practical_4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author admin
 */
public class P4Driver extends JFrame {
    public P4Driver() {
        JButton programmeJBT = new JButton("Maintain Programme");
        JButton studentJBT = new JButton("Maintain Student");
        
        setTitle("Maintain Information");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new GridLayout(2,1));
        
        add(programmeJBT);
        add(studentJBT);
        
        programmeJBT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MaintainProgrammeFrame();
            }
        });
        
        studentJBT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MaintainStudentFrame();
            }
        });
        
        
    }
    
    public static void main(String[] args) {
        new P4Driver();
    }
}

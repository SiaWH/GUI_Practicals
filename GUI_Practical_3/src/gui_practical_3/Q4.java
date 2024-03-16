/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_practical_3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author admin
 */

public class Q4 extends JFrame {
    
    JButton jbtSubmit = new JButton("Submit");
    JPasswordField jpfPassword = new JPasswordField(10);
    JTextArea jtaMessage = new JTextArea(5,30);

    public Q4() {
        setTitle("Set Password");
        setSize(400, 190);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(new BorderLayout());

        JPanel jpCenter = new JPanel(new GridLayout(2,2));
        jpCenter.add(new JLabel("Enter your password"));
        jpCenter.add(jpfPassword);
        jpCenter.add(new JLabel());
        jpCenter.add(jbtSubmit);
        
        add(jpCenter, BorderLayout.CENTER);
        add(jtaMessage, BorderLayout.SOUTH);
        jtaMessage.setLineWrap(true);
        jtaMessage.setWrapStyleWord(true);
        jtaMessage.setEditable(false);
        
        jbtSubmit.addActionListener(new ButtonListener());
        jpfPassword.addActionListener(new ButtonListener());
    }
    
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            jtaMessage.setText("");
            String inputStr = jpfPassword.getText();
            try {
                Password pw = new Password(inputStr);
                jtaMessage.setForeground(Color.BLUE);
                jtaMessage.setText("Congratulations! Your password is valid.");
            } catch (InvalidPasswordException ex) {
                jtaMessage.setForeground(Color.RED);
                jtaMessage.setText(ex.getMessage());
                jpfPassword.grabFocus();
            }
        }
    }

    public static void main(String[] args) {
        new Q4();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_practical_1;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author admin
 */
public class Q4 extends JFrame{

    public Q4() {
        setLayout(new GridLayout(4,2));
        setTitle("Student Information");

        add(new JLabel("registration number"));
        add(new JTextField(13));
        add(new JLabel("name"));
        add(new JTextField(13));
        add(new JLabel("programme code"));
        add(new JTextField(13));

        add(new JButton("Submit"));
        
        setSize(300, 220);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Q4();
    }
}

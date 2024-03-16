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
public class Q5 extends JFrame {

    public Q5() {
        setLayout(new FlowLayout());
        setTitle("P1Q5");

        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();

        panel.setLayout(new FlowLayout());
        panel2.setLayout(new FlowLayout());

        panel.add(new JButton("1"));
        panel.add(new JButton("2"));

        
        panel2.add(new JButton("1"));
        panel2.add(new JButton("2"));

        add(panel);
        add(panel2);

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Q5();
    }
}

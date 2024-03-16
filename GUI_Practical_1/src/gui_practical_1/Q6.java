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
public class Q6 extends JFrame {
    public Q6() {
        setTitle("P1Q6");

        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();

        panel.setLayout(new GridLayout(1,2));
        panel2.setLayout(new GridLayout(1,2));

        panel.add(new JButton("1"));
        panel.add(new JButton("2"));
        
        panel2.add(new JButton("3"));
        panel2.add(new JButton("4"));

        add(BorderLayout.SOUTH, panel);
        add(BorderLayout.CENTER, panel2);

        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Q6();
    }
}

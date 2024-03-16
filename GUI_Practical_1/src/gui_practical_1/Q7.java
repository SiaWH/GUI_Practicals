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
class MyPanel extends JPanel {
    public MyPanel() {
        setLayout(new GridLayout(1, 2));
        add(new JButton("Button 1"));
        add(new JButton("Button 2"));
    }
}

public class Q7 extends JFrame {
    public Q7() {
        setTitle("P1Q7");

        JPanel panel = new MyPanel();
        JPanel panel2 = new MyPanel();

        add(BorderLayout.SOUTH, panel);
        add(BorderLayout.CENTER, panel2);

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Q7();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_practical_1;
import javax.swing.*;

/**
 *
 * @author admin
 */
public class Q2 extends JFrame {
    private JButton jbtOk = new JButton("ok");
    
    public Q2() {
        super("One Frame");
        add(jbtOk);
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        Q2 myFrame = new Q2();
    }
}

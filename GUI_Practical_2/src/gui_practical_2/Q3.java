/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_practical_2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Q3 extends JFrame {
   
    private JLabel label;
   
    Q3() {
        JButton redButton = new JButton("Red");
        JButton greenButton = new JButton("Green");
        JButton blueButton = new JButton("Blue");
       
        Panel buttons = new Panel();
        buttons.setLayout(new FlowLayout());
       
        JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        label = new JLabel("COLOR");
        labelPanel.add(label);
       
        setTitle("Primary Colors");
        setSize(300, 100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
       
        setLayout(new BorderLayout());
        add(BorderLayout.NORTH, labelPanel);
       
        buttons.add(redButton);
        buttons.add(greenButton);
        buttons.add(blueButton);
       
        add(BorderLayout.CENTER, buttons);
       
        // Registering anonymous inner classes as ActionListeners for buttons
        redButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setForeground(Color.RED);
            }
        });
       
        greenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setForeground(Color.GREEN);
            }
        });
       
        blueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setForeground(Color.BLUE);
            }
        });
    }


    public static void main(String[] args) {
        new Q3();
    }
}

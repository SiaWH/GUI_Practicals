/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gui_practical_2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Q1 extends JFrame {
   
    private JLabel label;
   
    Q1() {
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
       
        redButton.addActionListener(new RedButtonListener());
        greenButton.addActionListener(new GreenButtonListener());
        blueButton.addActionListener(new BlueButtonListener());
       
    }
   
    // Inner listener class for Red button
    private class RedButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            label.setForeground(Color.RED);
        }
    }


    // Inner listener class for Green button
    private class GreenButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            label.setForeground(Color.GREEN);
        }
    }


    // Inner listener class for Blue button
    private class BlueButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            label.setForeground(Color.BLUE);
        }
    }


    public static void main(String[] args) {
        new Q1();
    }
   
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_practical_3;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author admin
 */
public class Q2 extends JFrame {
    
    public Q2() {
        
        int[] array = new int[100];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(2000);
        }
        
        setTitle("Display: Show Bounds Error");
        setSize(300, 120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(new BorderLayout());
        
        JPanel arrayPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        
        JButton show = new JButton("Show Element");
        
        buttonPanel.add(show);
        buttonPanel.setLayout(new GridLayout(1,1));
        
        JTextField input = new JTextField(10);
        JTextField element = new JTextField();
        element.setEnabled(false);
        element.setDisabledTextColor(Color.BLACK); 
        
        arrayPanel.add(new JLabel("Array Index"));
        arrayPanel.add(input);
        arrayPanel.add(new JLabel("Array Element"));
        arrayPanel.add(element);
        arrayPanel.setLayout(new GridLayout(2,2));
        
        add(arrayPanel);
        add(BorderLayout.SOUTH, buttonPanel);
        
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int index = Integer.parseInt(input.getText());
                    
                    if (index >= 0 && index < array.length) {
                        element.setText(String.valueOf(array[index]));
                    } else {
                        throw new ArrayIndexOutOfBoundsException();
                    }
                } catch (NumberFormatException ex) {
                    element.setText("Invalid Input");
                } catch (ArrayIndexOutOfBoundsException ex) {
                    element.setText("Out of Bound");
                }
            }
        });
    }
    
    public static void main(String[] args) {
        new Q2();
    }
}

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
public class SimpleCalculator extends JFrame {

    private JLabel jlblFirst = new JLabel("First Number");
    private JLabel jlblSecond = new JLabel("Second Number");
    private JLabel jlblResult = new JLabel("Result");
    private JTextField jtfFirst = new JTextField();
    private JTextField jtfSecond = new JTextField();
    private JTextField jtfResult = new JTextField();
    private JButton jbtAdd = new JButton("Add");
    private JButton jbtSubtract = new JButton("Subtract");
    private JButton jbtMultiply = new JButton("Multiply");
    private JButton jbtDivide = new JButton("Divide");

    public SimpleCalculator() {
        setTitle("Simple Calculator");
        Font font = new Font("Arial", Font.BOLD, 14);

        jlblFirst.setFont(font);
        jlblSecond.setFont(font);
        jlblResult.setFont(font);
        jtfFirst.setFont(font);
        jtfSecond.setFont(font);
        jtfResult.setFont(font);
        jbtAdd.setFont(font);
        jbtSubtract.setFont(font);
        jbtMultiply.setFont(font);
        jbtDivide.setFont(font);

        jtfResult.setEditable(false);

        JPanel jpCenter = new JPanel(new GridLayout(3, 2, 2, 2));
        jpCenter.add(jlblFirst);

        jpCenter.add(jtfFirst);
        jpCenter.add(jlblSecond);
        jpCenter.add(jtfSecond);
        jpCenter.add(jlblResult);
        jpCenter.add(jtfResult);
        add(jpCenter, BorderLayout.CENTER);

        JPanel jpSouth = new JPanel();
        jpSouth.add(jbtAdd);
        jpSouth.add(jbtSubtract);
        jpSouth.add(jbtMultiply);
        jpSouth.add(jbtDivide);
        add(jpSouth, BorderLayout.SOUTH);

        jbtAdd.addActionListener(new ButtonListener());
        jbtSubtract.addActionListener(new ButtonListener());
        jbtMultiply.addActionListener(new ButtonListener());
        jbtDivide.addActionListener(new ButtonListener());

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void clearTextFields() {
        jtfFirst.setText("");
        jtfSecond.setText("");
        jtfResult.setText("");
        jtfFirst.grabFocus();
    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double firstVal = Double.parseDouble(jtfFirst.getText());
                double secondVal = Double.parseDouble(jtfSecond.getText());
                double result = 0;
                if (e.getSource() == jbtAdd) {
                    result = firstVal + secondVal;
                } else if (e.getSource() == jbtSubtract) {
                    result = firstVal - secondVal;
                } else if (e.getSource() == jbtMultiply) {
                    result = firstVal * secondVal;
                } else if (e.getSource() == jbtDivide) {
                    if (secondVal == 0) {
                        throw new ArithmeticException("Cannot divide by zero");
                    }
                    result = firstVal / secondVal;
                }
                jtfResult.setText(String.valueOf(result));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter valid numbers.");
                clearTextFields();
            } catch (ArithmeticException ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                clearTextFields();
            }
        }
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gui_practical_1;
import javax.swing.*;

public class Q1a extends JFrame {

    public static void main(String[] args) {
        String temp;
        double fahrenheit;
        double celsius;
        
        do {
            temp = JOptionPane.showInputDialog("Enter temperature in Fahrenheit");

            if (isValidInput(temp)) {
                fahrenheit = Double.parseDouble(temp);

                celsius = (5.0 / 9.0) * (fahrenheit - 32);

                JOptionPane.showMessageDialog(null, "Temperature in Celsius: " + celsius);
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid temperature.");
            }

        } while (true);
    }
    
    private static boolean isValidInput(String input) {
        try {
            double temperature = Double.parseDouble(input);
            return temperature >= -459.67;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}


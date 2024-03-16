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
public class Q3 extends JFrame {

    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private java.util.Date loanDate;

    private JTextField annualInterestRateField = new JTextField(10);
    private JTextField numberOfYearsField = new JTextField(10);
    private JTextField loanAmountField = new JTextField(10);
    private JTextField monthlyPaymentField = new JTextField(10);
    private JTextField totalPaymentField = new JTextField(10);
    private JButton calculateButton = new JButton("Calculate");

    public Q3(double annualInterestRate, int numberOfYears, double loanAmount) {
        if (annualInterestRate <= 0) {
            throw new IllegalArgumentException("Annual interest rate must be greater than 0.");
        }
        if (numberOfYears <= 0) {
            throw new IllegalArgumentException("Number of years must be greater than 0.");
        }
        if (loanAmount <= 0) {
            throw new IllegalArgumentException("Number of loan amount must be greater than 0.");
        }
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        loanDate = new java.util.Date();
    }

    public Q3() {
        setTitle("Loan Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        inputPanel.add(new JLabel("Annual Interest Rate (%):"));
        inputPanel.add(annualInterestRateField);
        inputPanel.add(new JLabel("Number of Years:"));
        inputPanel.add(numberOfYearsField);
        inputPanel.add(new JLabel("Loan Amount:"));
        inputPanel.add(loanAmountField);
        inputPanel.add(new JLabel("Monthly Payment:"));
        inputPanel.add(monthlyPaymentField);
        monthlyPaymentField.setEditable(false);
        inputPanel.add(new JLabel("Total Payment:"));
        inputPanel.add(totalPaymentField);
        totalPaymentField.setEditable(false);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(calculateButton);
        buttonPanel.setLayout(new FlowLayout());

        setLayout(new BorderLayout());
        add(inputPanel);
        add(buttonPanel, BorderLayout.SOUTH);

        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double annualInterestRate = Double.parseDouble(annualInterestRateField.getText());
                    int numberOfYears = Integer.parseInt(numberOfYearsField.getText());
                    double loanAmount = Double.parseDouble(loanAmountField.getText());
                    
                    Q3 loan = new Q3(annualInterestRate, numberOfYears, loanAmount);

                    monthlyPaymentField.setText(String.format("%.2f", loan.getMonthlyPayment()));
                    totalPaymentField.setText(String.format("%.2f", loan.getTotalPayment()));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input! Please enter valid numbers.");
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        if (annualInterestRate <= 0) {
            throw new IllegalArgumentException("Annual interest rate must be greater than 0.");
        }
        this.annualInterestRate = annualInterestRate;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public void setNumberOfYears(int numberOfYears) {
        if (numberOfYears <= 0) {
            throw new IllegalArgumentException("Number of years must be greater than 0.");
        }
        this.numberOfYears = numberOfYears;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        if (loanAmount <= 0) {
            throw new IllegalArgumentException("Number of loan amount must be greater than 0.");
        }
        this.loanAmount = loanAmount;
    }

    /**
     * Find monthly payment
     */
    public double getMonthlyPayment() {
        double monthlyInterestRate = annualInterestRate / 1200;
        return loanAmount * monthlyInterestRate / (1 - (Math.pow(1 / (1 + monthlyInterestRate), numberOfYears * 12)));
    }

    /**
     * Find total payment
     */
    public double getTotalPayment() {
        return getMonthlyPayment() * numberOfYears * 12;
    }

    /**
     * Return loan date
     */
    public java.util.Date getLoanDate() {
        return loanDate;
    }

    public static void main(String[] args) {
        new Q3();
    }
}

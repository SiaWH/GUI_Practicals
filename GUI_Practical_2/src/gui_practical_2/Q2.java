/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_practical_2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Q2 extends JFrame {
   
    private JLabel label;
   
    Q2() {
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
       
        ButtonListener buttonListener = new ButtonListener();


        redButton.addActionListener(buttonListener);
        greenButton.addActionListener(buttonListener);
        blueButton.addActionListener(buttonListener);
       
    }
   
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Get the source of the event (which button was clicked)
            JButton buttonClicked = (JButton) e.getSource();
           
            // Set the label's foreground color based on the button clicked
            if (buttonClicked.getText().equals("Red")) {
                label.setForeground(Color.RED);
            } else if (buttonClicked.getText().equals("Green")) {
                label.setForeground(Color.GREEN);
            } else if (buttonClicked.getText().equals("Blue")) {
                label.setForeground(Color.BLUE);
            }
        }
    }
   
    public static void main(String[] args) {
        new Q2();
    }
}

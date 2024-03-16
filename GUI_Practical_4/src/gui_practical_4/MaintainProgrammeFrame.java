package gui_practical_4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MaintainProgrammeFrame extends JFrame {

    private MaintainProgrammeControl progControl;
    private JTextField jtfCode = new JTextField();
    private JTextField jtfName = new JTextField();
    private JTextField jtfFaculty = new JTextField();
    private JButton jbtAdd = new JButton("Create");
    private JButton jbtRetrieve = new JButton("Retrieve");
    private JButton jbtUpdate = new JButton("Update");
    private JButton jbtDelete = new JButton("Delete");

    public MaintainProgrammeFrame() {
        progControl = new MaintainProgrammeControl();
        
        setTitle("Programme CRUD");
        setSize(600, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        JPanel jpCenter = new JPanel(new GridLayout(3, 2));
        jpCenter.add(new JLabel("Programme Code"));
        jpCenter.add(jtfCode);
        jpCenter.add(new JLabel("Programme Name"));
        jpCenter.add(jtfName);
        jpCenter.add(new JLabel("Faculty"));
        jpCenter.add(jtfFaculty);
        add(jpCenter);

        JPanel jpSouth = new JPanel();
        jpSouth.add(jbtAdd);
        jpSouth.add(jbtRetrieve);
        jpSouth.add(jbtUpdate);
        jpSouth.add(jbtDelete);
        add(jpSouth, BorderLayout.SOUTH);

        jbtAdd.addActionListener(new CreateListener());
        jbtRetrieve.addActionListener(new RetrieveListener());
        jbtUpdate.addActionListener(new UpdateListener());
        jbtDelete.addActionListener(new DeleteListener());
    }
    
    private class CreateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String code = jtfCode.getText();
            String faculty = jtfFaculty.getText();
            String name = jtfName.getText();
            
            Programme programme = progControl.selectRecord(code);
            if (programme != null) {
                JOptionPane.showMessageDialog(null, "This programme is already existed", "RECORD FOUND", JOptionPane.ERROR_MESSAGE);
            } else {
                Programme newProgramme = new Programme(code, name, faculty);
                if (progControl.addRecord(newProgramme)) {
                    JOptionPane.showMessageDialog(null, "Created successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "Oops! Somethings when wrong...");
                }
            }
        }
    }

    private class RetrieveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String code = jtfCode.getText();
            Programme programme = progControl.selectRecord(code);
            if (programme != null) {
                jtfName.setText(programme.getName());
                jtfFaculty.setText(programme.getFaculty());
            } else {
                JOptionPane.showMessageDialog(null, "No such programme code.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private class UpdateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String code = jtfCode.getText();
            String faculty = jtfFaculty.getText();
            String name = jtfName.getText();
            
            if (code.isEmpty() && faculty.isEmpty() && name.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No empty space is allowed to be update");
            } else {
                Programme programme = progControl.selectRecord(code);
                if (programme == null) {
                    JOptionPane.showMessageDialog(null, "No such programme.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
                } else {
                    Programme updateProgramme = new Programme(code, name, faculty);
                    
                        if (progControl.renewRecord(updateProgramme)) {
                            JOptionPane.showMessageDialog(null, "Updated successfully!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Oops! Somethings when wrong...");
                        }
                    }
                }
            }
        }
    
    private class DeleteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String code = jtfCode.getText();
            Programme programme = progControl.selectRecord(code);
            if (programme != null) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    if (progControl.removeRecord(code)) {
                        JOptionPane.showMessageDialog(null, "Record deleted successfully!");
                        clearTextFields();
                    } else {
                        JOptionPane.showMessageDialog(null, "Oops! Something went wrong while deleting the record.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "No such programme code.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void clearTextFields() {
        jtfCode.setText("");
        jtfFaculty.setText("");
        jtfName.setText("");
    }

}

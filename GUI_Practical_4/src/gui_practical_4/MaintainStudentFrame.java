package gui_practical_4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MaintainStudentFrame extends JFrame {

    private MaintainStudentControl studControl;
    private MaintainProgrammeControl progControl;
    private JTextField jtfId = new JTextField();
    private JTextField jtfIC = new JTextField();
    private JTextField jtfName = new JTextField();
    private JTextField jtfLevel = new JTextField();
    private JTextField jtfProgrammeCode = new JTextField();
    private JTextField jtfYear = new JTextField();
    private JButton jbtCreate = new JButton("Create");
    private JButton jbtRetrieve = new JButton("Retrieve");
    private JButton jbtUpdate = new JButton("Update");
    private JButton jbtDelete = new JButton("Delete");

    public MaintainStudentFrame() {
        studControl = new MaintainStudentControl();
        
        setTitle("Student CRUD");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        JPanel jpCenter = new JPanel(new GridLayout(6, 2));
        jpCenter.add(new JLabel("Student ID"));
        jpCenter.add(jtfId);
        jpCenter.add(new JLabel("IC"));
        jpCenter.add(jtfIC);
        jpCenter.add(new JLabel("Name"));
        jpCenter.add(jtfName);
        jpCenter.add(new JLabel("Level"));
        jpCenter.add(jtfLevel);
        jpCenter.add(new JLabel("Programme Code"));
        jpCenter.add(jtfProgrammeCode);
        jpCenter.add(new JLabel("Year"));
        jpCenter.add(jtfYear);
        add(jpCenter);

        JPanel jpSouth = new JPanel();
        jpSouth.add(jbtCreate);
        jpSouth.add(jbtRetrieve);
        jpSouth.add(jbtUpdate);
        jpSouth.add(jbtDelete);
        add(jpSouth, BorderLayout.SOUTH);

        jbtCreate.addActionListener(new CreateListener());
        jbtRetrieve.addActionListener(new RetrieveListener());
        jbtUpdate.addActionListener(new UpdateListener());
        jbtDelete.addActionListener(new DeleteListener());
        
        
    }
    
    private class CreateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String id = jtfId.getText();
            String ic = jtfIC.getText();
            String name = jtfName.getText();
            char level = jtfLevel.getText().charAt(0);
            String programmeCode = jtfProgrammeCode.getText();
            int year = Integer.parseInt(jtfYear.getText());
            
            Programme programme = progControl.selectRecord(programmeCode);
            Student studentById = studControl.selectRecordById(id);
            Student studentByIc = studControl.selectRecordByIc(ic);
            if (studentById != null) {
                JOptionPane.showMessageDialog(null, "This ID is already existed", "RECORD FOUND", JOptionPane.ERROR_MESSAGE);
            } else if (studentByIc != null) {
                JOptionPane.showMessageDialog(null, "This IC is already existed", "RECORD FOUND", JOptionPane.ERROR_MESSAGE);
            } else if (programme == null) {
                JOptionPane.showMessageDialog(null, "This programme is not exist", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
            } else {
                Student student = new Student(id, ic, name, level, programme, year);
                if (studControl.addRecord(student)) {
                    JOptionPane.showMessageDialog(null, "Created successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "Oops! Somethings when wrong...");
                }
            }
        }
    }
    
    private void setDataById(Student studentById) {
        Programme studProgramme = studentById.getProgramme();
        jtfIC.setText(studentById.getIc());
        jtfName.setText(studentById.getName());
        jtfLevel.setText(String.valueOf(studentById.getLevel()));
        jtfProgrammeCode.setText(studProgramme.getCode());
        jtfYear.setText(String.valueOf(studentById.getYear()));
    }
    
    private void setDataByIc(Student studentByIc) {
        Programme studProgramme = studentByIc.getProgramme();
        jtfId.setText(studentByIc.getId());
        jtfName.setText(studentByIc.getName());
        jtfLevel.setText(String.valueOf(studentByIc.getLevel()));
        jtfProgrammeCode.setText(studProgramme.getCode());
        jtfYear.setText(String.valueOf(studentByIc.getYear()));
    }
    
    private class RetrieveListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String id = jtfId.getText();
            String ic = jtfIC.getText();
            Student studentById = studControl.selectRecordById(id);
            Student studentByIc = studControl.selectRecordByIc(ic);
            
            if (ic.isEmpty() && !id.isEmpty()) {
                if (studentById != null) {
                    setDataById(studentById);
                } else {
                    JOptionPane.showMessageDialog(null, "No such student ID.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
                }
                
            } else if (id.isEmpty() && !ic.isEmpty()) {
                if (studentByIc != null) {
                    setDataByIc(studentByIc);
                } else {
                    JOptionPane.showMessageDialog(null, "No such student IC.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
                }
            } else if (!id.isEmpty() && !ic.isEmpty()) {
                if (studentById == null) {
                    if (studentByIc == null) {
                        JOptionPane.showMessageDialog(null, "No such student.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
                    } else {
                        setDataByIc(studentByIc);
                    }
                } else {
                    setDataById(studentById);
                }
            }
        }
    }
    
    private class UpdateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String id = jtfId.getText();
            String ic = jtfIC.getText();
            String name = jtfName.getText();
            char level = jtfLevel.getText().charAt(0);
            String programmeCode = jtfProgrammeCode.getText();
            int year = Integer.parseInt(jtfYear.getText());
            
            if (id.isEmpty() && ic.isEmpty() && name.isEmpty() && level == '\u0000' && programmeCode.isEmpty() && year == 0) {
                JOptionPane.showMessageDialog(null, "No empty space is allowed to be update");
            } else {
                Student studentById = studControl.selectRecordById(id);
                Student studentByIc = studControl.selectRecordByIc(ic);
                Programme programme = progControl.selectRecord(programmeCode);
                if (studentById == null) {
                    JOptionPane.showMessageDialog(null, "No such student ID.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
                } else if (programme == null) {
                    JOptionPane.showMessageDialog(null, "No such programme.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
                } else {
                    Student updateStudent = new Student(id, ic, name, level, programme, year);
                    if (studentByIc != null) {
                        if (studentByIc.getIc().equals(ic)) {
                            if (studControl.renewRecord(updateStudent)) {
                                JOptionPane.showMessageDialog(null, "Created successfully!");
                            } else {
                                JOptionPane.showMessageDialog(null, "Oops! Somethings when wrong...");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "This IC has been used.", "RECORD FOUND", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        if (studControl.renewRecord(updateStudent)) {
                            JOptionPane.showMessageDialog(null, "Updated successfully!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Oops! Somethings when wrong...");
                        }
                    }
                }
            }
        }
    }
    
    private class DeleteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String id = jtfId.getText();
            Student student = studControl.selectRecordById(id);
            if (student != null) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    if (studControl.removeRecord(id)) {
                        JOptionPane.showMessageDialog(null, "Record deleted successfully!");
                        clearTextFields();
                    } else {
                        JOptionPane.showMessageDialog(null, "Oops! Something went wrong while deleting the record.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "No such student ID.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void clearTextFields() {
        jtfId.setText("");
        jtfIC.setText("");
        jtfName.setText("");
        jtfLevel.setText("");
        jtfProgrammeCode.setText("");
        jtfYear.setText("");
    }

}

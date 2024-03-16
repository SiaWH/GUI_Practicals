package gui_practical_4;

public class MaintainStudentControl {

    private StudentDA studDA;

    public MaintainStudentControl() {
        studDA = new StudentDA();
    }
    
    public Student selectRecordById(String id) {
        return studDA.getRecordById(id);
    }
    
    public Student selectRecordByIc(String ic) {
        return studDA.getRecordByIc(ic);
    }
    
    public boolean addRecord(Student newStudent) {
        return studDA.createRecord(newStudent);
    }
    
    public boolean renewRecord(Student student) {
        return studDA.updateRecord(student);
    }
    
    public boolean removeRecord(String id) {
        return studDA.deleteRecord(id);
    }

}

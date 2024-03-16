package gui_practical_4;

public class MaintainProgrammeControl {

    private ProgrammeDA progDA;

    public MaintainProgrammeControl() {
        progDA = new ProgrammeDA();
    }

    public Programme selectRecord(String code) {
        return progDA.getRecord(code);
    }
    
    public boolean addRecord(Programme newProgramme) {
        return progDA.createRecord(newProgramme);
    }
    
    public boolean renewRecord(Programme programme) {
        return progDA.updateRecord(programme);
    }
    
    public boolean removeRecord(String code) {
        return progDA.deleteRecord(code);
    }

}

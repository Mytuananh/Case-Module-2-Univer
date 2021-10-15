package cotroller.teachermanager;

import model.teachers.MechanicsTeacher;

import java.util.ArrayList;

public class MechanicsTeacherManager {
    ArrayList<MechanicsTeacher> mechanicsTeacherArrayList = new ArrayList<>();

    public MechanicsTeacherManager(ArrayList<MechanicsTeacher> mechanicsTeacherArrayList) {
        this.mechanicsTeacherArrayList = mechanicsTeacherArrayList;
    }

    public ArrayList<MechanicsTeacher> getMechanicsTeacherArrayList() {
        return mechanicsTeacherArrayList;
    }

    public void addNewStudent(MechanicsTeacher mechanicsTeacher) {
       mechanicsTeacherArrayList.add(mechanicsTeacher);
    }

    public void removeStudent(int index) {
       mechanicsTeacherArrayList.remove(index);
    }

    public void setMechanicsTeacherArrayList(int index, MechanicsTeacher mechanicsTeacher) {
        mechanicsTeacherArrayList.set(index,mechanicsTeacher);
    }

    public MechanicsTeacher searchTeacher(String codeTeacher) {
        MechanicsTeacher mechanicsTeacher = null;
        for (int i = 0; i < mechanicsTeacherArrayList.size(); i++) {
            if (mechanicsTeacherArrayList.get(i).getCodeTeacher().equals(codeTeacher)) {
                mechanicsTeacher = getMechanicsTeacherArrayList().get(i);
                break;
            }
        }
        return mechanicsTeacher;
    }
}

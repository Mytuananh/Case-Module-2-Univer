package cotroller.teachermanager;

import model.teachers.MathTeacher;

import java.util.ArrayList;

public class MathTeacherManager {
    ArrayList<MathTeacher> mathTeacherArrayList = new ArrayList<>();

    public MathTeacherManager(ArrayList<MathTeacher> mathTeacherArrayList) {
        this.mathTeacherArrayList = mathTeacherArrayList;
    }

    public ArrayList<MathTeacher> getMathTeacherArrayList() {
        return mathTeacherArrayList;
    }

    public void addNewStudent(MathTeacher mathTeacher) {
        mathTeacherArrayList.add(mathTeacher);
    }

    public void removeStudent(int index) {
        mathTeacherArrayList.remove(index);
    }

    public void setMathTeacherArrayList(int index, MathTeacher mathTeacher) {
        mathTeacherArrayList.set(index, mathTeacher);
    }

    public MathTeacher searchTeacher(String codeTeacher) {
        MathTeacher mathTeacher = null;
        for (int i = 0; i < mathTeacherArrayList.size(); i++) {
            if (mathTeacherArrayList.get(i).getCodeTeacher().equals(codeTeacher)) {
                mathTeacher = getMathTeacherArrayList().get(i);
                break;
            }
        }
        return mathTeacher;
    }
}

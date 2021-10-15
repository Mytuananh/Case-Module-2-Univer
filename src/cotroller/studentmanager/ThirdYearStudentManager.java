package cotroller.studentmanager;

import model.stduents.ThirdYearStudent;

import java.util.ArrayList;

public class ThirdYearStudentManager {
    ArrayList<ThirdYearStudent> thirdYearStudentArrayList = new ArrayList<>();

    public ThirdYearStudentManager(ArrayList<ThirdYearStudent> thirdYearStudentArrayList) {
        this.thirdYearStudentArrayList = thirdYearStudentArrayList;
    }

    public ArrayList<ThirdYearStudent> getThirdYearStudentArrayList() {
        return thirdYearStudentArrayList;
    }

    public void addNewStudent(ThirdYearStudent thirdYearStudent) {
        thirdYearStudentArrayList.add(thirdYearStudent);
    }

    public void removeStudent(int index) {
        thirdYearStudentArrayList.remove(index);
    }

    public void setThirdYearStudentArrayList(int index, ThirdYearStudent thirdYearStudent) {
        thirdYearStudentArrayList.set(index, thirdYearStudent);
    }

    public ThirdYearStudent searchStudent(String codeStudent) {
        ThirdYearStudent thirdYearStudent = null;
        for (int i = 0; i < thirdYearStudentArrayList.size(); i++) {
            if (thirdYearStudentArrayList.get(i).getCodeStudent().equals(codeStudent)) {
                thirdYearStudent = getThirdYearStudentArrayList().get(i);
                break;
            }
        }
        return thirdYearStudent;
    }
}

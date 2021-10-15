package cotroller.studentmanager;

import model.stduents.FourthYearStudent;

import java.util.ArrayList;

public class FourthYearStudentManager {
    ArrayList<FourthYearStudent> fourthYearStudentArrayList = new ArrayList<>();

    public FourthYearStudentManager(ArrayList<FourthYearStudent> fourthYearStudentArrayList) {
        this.fourthYearStudentArrayList = fourthYearStudentArrayList;
    }

    public ArrayList<FourthYearStudent> getFourthYearStudentArrayList() {
        return fourthYearStudentArrayList;
    }

    public void addNewStudent(FourthYearStudent fourthYearStudent) {
        fourthYearStudentArrayList.add(fourthYearStudent);
    }

    public void removeStudent(int index) {
        fourthYearStudentArrayList.remove(index);
    }

    public void setFourthYearStudentArrayList(int index, FourthYearStudent fourthYearStudent) {
        fourthYearStudentArrayList.set(index, fourthYearStudent);
    }

    public FourthYearStudent searchStudent(String codeStudent) {
        FourthYearStudent fourthYearStudent = null;
        for (int i = 0; i < fourthYearStudentArrayList.size(); i++) {
            if (fourthYearStudentArrayList.get(i).getCodeStudent().equals(codeStudent)) {
                fourthYearStudent = getFourthYearStudentArrayList().get(i);
                break;
            }
        }
        return fourthYearStudent;
    }
}

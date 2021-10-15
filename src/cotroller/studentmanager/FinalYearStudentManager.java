package cotroller.studentmanager;

import model.stduents.FinalYearStudent;

import java.util.ArrayList;

public class FinalYearStudentManager {
    ArrayList<FinalYearStudent> finalYearStudentArrayList = new ArrayList<>();

    public FinalYearStudentManager(ArrayList<FinalYearStudent> finalYearStudentArrayList) {
        this.finalYearStudentArrayList = finalYearStudentArrayList;
    }

    public ArrayList<FinalYearStudent> getFinalYearStudentArrayList() {
        return finalYearStudentArrayList;
    }

    public void addNewStudent(FinalYearStudent finalYearStudent) {
        finalYearStudentArrayList.add(finalYearStudent);
    }

    public void removeStudent(int index) {
        finalYearStudentArrayList.remove(index);
    }

    public void setFinalYearStudentArrayList(int index, FinalYearStudent finalYearStudent) {
        finalYearStudentArrayList.set(index, finalYearStudent);
    }

    public FinalYearStudent searchStudent(String codeStudent) {
        FinalYearStudent finalYearStudent = null;
        for (int i = 0; i < finalYearStudentArrayList.size(); i++) {
            if (finalYearStudentArrayList.get(i).getCodeStudent().equals(codeStudent)) {
                finalYearStudent = getFinalYearStudentArrayList().get(i);
                break;
            }
        }
        return finalYearStudent;
    }
}

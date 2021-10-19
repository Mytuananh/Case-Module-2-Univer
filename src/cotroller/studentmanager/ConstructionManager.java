package cotroller.studentmanager;

import model.students.ConstructionStudent;

import java.util.ArrayList;

public class ConstructionManager {
    ArrayList<ConstructionStudent> constructionStudentArrayList = new ArrayList<>();

    public ConstructionManager(ArrayList<ConstructionStudent> constructionStudentArrayList) {
        this.constructionStudentArrayList = constructionStudentArrayList;
    }

    public ConstructionManager() {

    }

    public ArrayList<ConstructionStudent> getFreshmanArrayList() {
        return constructionStudentArrayList;
    }

    public void addNewStudent(ConstructionStudent constructionStudent) {
        constructionStudentArrayList.add(constructionStudent);
    }

    public void removeStudent(int index) {
        constructionStudentArrayList.remove(index);
    }

    public void setFreshmanArrayList(int index, ConstructionStudent constructionStudent) {
        constructionStudentArrayList.set(index, constructionStudent);
    }

    public ConstructionStudent searchStudent(String codeStudent) {
        ConstructionStudent constructionStudent = null;
        for (int i = 0; i < constructionStudentArrayList.size(); i++) {
            if (constructionStudentArrayList.get(i).getCodeStudent().equals(codeStudent)) {
                constructionStudent = getFreshmanArrayList().get(i);
                break;
            }
        }
        return constructionStudent;
    }


}

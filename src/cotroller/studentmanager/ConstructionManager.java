package cotroller.studentmanager;

import model.students.ConstructionStudent;
import storage.studenttext.ConstructionReadWriteFile;

import java.io.IOException;
import java.util.ArrayList;

public class ConstructionManager {
    private static ConstructionManager constructionManager = new ConstructionManager();
    ArrayList<ConstructionStudent> constructionStudentArrayList = new ArrayList<>();
    ConstructionReadWriteFile constructionReadWriteFile = ConstructionReadWriteFile.getInstance();

    public ConstructionManager() {
    }

    public static ConstructionManager getInstance() {
        return constructionManager;
    }

    public ConstructionManager(ArrayList<ConstructionStudent> constructionStudentArrayList) {
        this.constructionStudentArrayList = constructionStudentArrayList;
    }

    public ArrayList<ConstructionStudent> getConstructionStudentArrayList() {
        return constructionStudentArrayList;
    }

    public void setConstructionStudentArrayList(ArrayList<ConstructionStudent> constructionStudentArrayList) {
        this.constructionStudentArrayList = constructionStudentArrayList;
    }

    public void addNewStudent(ConstructionStudent constructionStudent) {
        constructionStudentArrayList.add(constructionStudent);
        try {
            constructionReadWriteFile.writeFile(constructionStudentArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeStudent(String codeStudent) {
        ConstructionStudent constructionStudent = searchStudent(codeStudent);
        if (constructionStudent != null) {
            for (int i = 0; i < constructionStudentArrayList.size(); i++) {
                if (constructionStudentArrayList.get(i).equals(constructionStudent)) {
                    constructionStudentArrayList.remove(i);
                }
            }
        } else {
            System.out.println("Not Found ConstructionStudent!");
        }
        try {
            constructionReadWriteFile.writeFile(constructionStudentArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void editConstructionStudentArrayList(String codeStudent, ConstructionStudent constructionStudent) {
        ConstructionStudent constructionStudent1 = searchStudent(codeStudent);
        if (constructionStudent1 != null) {
            for (int i = 0; i < constructionStudentArrayList.size(); i++) {
                if (constructionStudentArrayList.get(i).equals(constructionStudent1)) {
                    constructionStudentArrayList.set(i, constructionStudent);
                }
            }
        } else {
            System.out.println("Not Found ConstructionStudent!");
        }
        try {
            constructionReadWriteFile.writeFile(constructionStudentArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ConstructionStudent searchStudent(String codeStudent) {
        ConstructionStudent constructionStudent = null;
        for (int i = 0; i < constructionStudentArrayList.size(); i++) {
            if (constructionStudentArrayList.get(i).getCodeStudent().equals(codeStudent)) {
                constructionStudent = getConstructionStudentArrayList().get(i);
                break;
            }
        }
        return constructionStudent;
    }


}

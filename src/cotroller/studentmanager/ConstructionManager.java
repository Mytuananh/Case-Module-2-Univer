package cotroller.studentmanager;

import model.students.AccountantStudent;
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
        if (constructionStudentArrayList != null) {
            for (int i = 0; i < constructionStudentArrayList.size(); i++) {
                if (constructionStudentArrayList.get(i).getCodeStudent().equals(codeStudent)) {
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
        if (constructionStudentArrayList != null) {
            for (int i = 0; i < constructionStudentArrayList.size(); i++) {
                if (constructionStudentArrayList.get(i).getCodeStudent().equals(codeStudent)) {
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
        for (ConstructionStudent con: constructionStudentArrayList) {
            if (con.getCodeStudent().equals(codeStudent)) {
                constructionStudent = con;
                break;
            }
        }
        return constructionStudent;
    }

    public void showConstructionStudent() {
        for (ConstructionStudent con: constructionStudentArrayList) {
            System.out.println(con);
        }
    }


}

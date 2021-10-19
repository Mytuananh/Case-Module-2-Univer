package cotroller.studentmanager;

import model.students.AdministrationStudent;
import storage.studenttext.AdministrationReadWriteFile;

import java.io.IOException;
import java.util.ArrayList;

public class AdministrationManager {
    private static AdministrationManager administrationManager = new AdministrationManager();
    ArrayList<AdministrationStudent> administrationStudentArrayList = new ArrayList<>();
    AdministrationReadWriteFile administrationReadWriteFile = AdministrationReadWriteFile.getInstance();

    private AdministrationManager() {
    }

    public static AdministrationManager getInstance() {
        return administrationManager;
    }

    public AdministrationManager(ArrayList<AdministrationStudent> administrationStudentArrayList) {
        this.administrationStudentArrayList = administrationStudentArrayList;
    }

    public ArrayList<AdministrationStudent> getAdministrationStudentArrayList() {
        return administrationStudentArrayList;
    }

    public void setAdministrationStudentArrayList(ArrayList<AdministrationStudent> administrationStudentArrayList) {
        this.administrationStudentArrayList = administrationStudentArrayList;
    }

    public void addNewStudent(AdministrationStudent administrationStudent) {
        administrationStudentArrayList.add(administrationStudent);
        try {
            administrationReadWriteFile.writeFile(administrationStudentArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeStudent(String codeStudent) {
        AdministrationStudent administrationStudent = searchStudent(codeStudent);
        if (administrationStudent != null) {
            for (int i = 0; i < administrationStudentArrayList.size(); i++) {
                if (administrationStudentArrayList.get(i).equals(administrationStudent)) {
                    administrationStudentArrayList.remove(i);
                }
            }
        } else {
            System.out.println("Not Found AdministrationStudent!");
        }
        try {
            administrationReadWriteFile.writeFile(administrationStudentArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void editAdministrationStudentArrayList(String codeStudent, AdministrationStudent administrationStudent) {
        AdministrationStudent administrationStudent1 = searchStudent(codeStudent);
        if (administrationStudent1 != null) {
            for (int i = 0; i < administrationStudentArrayList.size(); i++) {
                if (administrationStudentArrayList.get(i).equals(administrationStudent1)) {
                    administrationStudentArrayList.set(i, administrationStudent);
                }
            }
        } else {
            System.out.println("Not Found AdministrationStudent!");
        }
        try {
            administrationReadWriteFile.writeFile(administrationStudentArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public AdministrationStudent searchStudent(String codeStudent) {
        AdministrationStudent administrationStudent = null;
        for (int i = 0; i < administrationStudentArrayList.size(); i++) {
            if (administrationStudentArrayList.get(i).getCodeStudent().equals(codeStudent)) {
                administrationStudent = getAdministrationStudentArrayList().get(i);
                break;
            }
        }
        return administrationStudent;
    }
}

package cotroller.studentmanager;

import model.students.AccountantStudent;
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
        if (administrationStudentArrayList != null) {
            for (int i = 0; i < administrationStudentArrayList.size(); i++) {
                if (administrationStudentArrayList.get(i).getCodeStudent().equals(codeStudent)) {
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
        if (administrationStudentArrayList != null) {
            for (int i = 0; i < administrationStudentArrayList.size(); i++) {
                if (administrationStudentArrayList.get(i).getCodeStudent().equals(codeStudent)) {
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
        for (AdministrationStudent adm: administrationStudentArrayList) {
            if (adm.getCodeStudent().equals(codeStudent)) {
                administrationStudent = adm;
                break;
            }
        }
        return administrationStudent;
    }
    public void showAdministrationStudent() {
        for (AdministrationStudent acc: administrationStudentArrayList) {
            System.out.println(acc);
        }
    }
}

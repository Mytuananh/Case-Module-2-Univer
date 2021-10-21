package cotroller.management;

import model.subject.SubjectStudent;
import storage.subjecttext.SubjectStudentText;

import java.io.IOException;
import java.util.ArrayList;

public class SubjectStudentManager {
    private static SubjectStudentManager subjectStudentManager = new SubjectStudentManager();
    ArrayList<SubjectStudent> subjectStudentArrayList = new ArrayList<>();
    SubjectStudentText subjectStudentText = SubjectStudentText.getInstance();

    private SubjectStudentManager() {
    }

    public static SubjectStudentManager getInstance() {
        return subjectStudentManager;
    }

    public SubjectStudentManager(ArrayList<SubjectStudent> subjectStudentArrayList) {
        this.subjectStudentArrayList = subjectStudentArrayList;
    }

    public ArrayList<SubjectStudent> getSubjectStudentArrayList() {
        return subjectStudentArrayList;
    }

    public void setSubjectStudentArrayList(ArrayList<SubjectStudent> subjectStudentArrayList) {
        this.subjectStudentArrayList = subjectStudentArrayList;
    }

    public void addNewSubjectStudent(SubjectStudent subjectStudent) {
        subjectStudentArrayList.add(subjectStudent);
        try {
            subjectStudentText.writeFile(subjectStudentArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

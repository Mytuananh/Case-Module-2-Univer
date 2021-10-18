package cotroller.management;

import model.Subject;

import java.util.ArrayList;

public class SubjectManager {
    ArrayList<Subject> subjectArrayList = new ArrayList<>();

    public SubjectManager(ArrayList<Subject> subjectArrayList) {
        this.subjectArrayList = subjectArrayList;
    }

    public ArrayList<Subject> getSubjectArrayList() {
        return subjectArrayList;
    }

    public void addNewSubject(Subject subject) {
        subjectArrayList.add(subject);
    }
}

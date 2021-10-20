package view.subjectview;

import cotroller.management.SubjectManager;
import model.subject.Subject;

import java.util.ArrayList;

public class Math {
    private static Math math = new Math();
    private Math() {
    }
    public static Math getInstance() {
        return math;
    }
    public  void runMath() {
        SubjectManager subjectManager = SubjectManager.getInstance();
        ArrayList<Subject> mathArrayList = new ArrayList<>();
        Subject subject = new Subject("ToánI", 320, "Tien Thanh", "T1");
        Subject subject1 = new Subject("ToánII", 640, "Xuan An", "T2");
        Subject subject2 = new Subject("ToánIII", 640, "Mai Tue", "T3");
        Subject subject3 = new Subject("ToánIV", 640, "Hong Dao", "T4");
        subjectManager.setSubjectArrayList(mathArrayList);
        subjectManager.addNewSubject(subject);
        subjectManager.addNewSubject(subject1);
        subjectManager.addNewSubject(subject2);
        subjectManager.addNewSubject(subject3);
        subjectManager.showSubject();

    }
}

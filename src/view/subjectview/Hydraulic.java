package view.subjectview;

import cotroller.management.SubjectManager;
import model.subject.Subject;

import java.util.ArrayList;

public class Hydraulic {
    private static Hydraulic hydraulic = new Hydraulic();
    private Hydraulic() {
    }

    public static Hydraulic getInstance() {
        return hydraulic;
    }
    public void runHydraulic() {
        SubjectManager subjectManager = SubjectManager.getInstance();
        ArrayList<Subject> hydraulicArrayList = new ArrayList<>();
        Subject subject1 = new Subject("Đập và Hồ chứa", 640,"Mong Quy","DH1");
        Subject subject2 = new Subject("Động lực học công trình", 640, "Dao Hong", "DT1");
        Subject subject3 = new Subject("Công trình trên hệ thống thủy lợi", 640, "Van Lang", "CL1");
        subjectManager.setSubjectArrayList(hydraulicArrayList);
        subjectManager.addNewSubject(subject1);
        subjectManager.addNewSubject(subject2);
        subjectManager.addNewSubject(subject3);
        subjectManager.showSubject();

    }
}

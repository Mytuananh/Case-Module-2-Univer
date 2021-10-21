package view.subjectview;

import cotroller.management.SubjectManager;
import model.subject.Subject;

import java.util.ArrayList;

public class English {
    private static English english = new English();
    private English() {
    }

    public static English getInstance() {
        return  english;
    }
    SubjectManager subjectManager = SubjectManager.getInstance();
    ArrayList<Subject> englishArrayList = new ArrayList<>();
    public void runEnglish() {
        Subject english1 = new Subject("EnglishI",320,"Xuan Anh","A1");
        Subject english2 = new Subject("EnglishII", 640, "Mong Lan","A2");
        Subject english3 = new Subject("EnglishIII", 640, "Hoai Anh","A3");
        subjectManager.setSubjectArrayList(englishArrayList);
        subjectManager.addNewSubject(english1);
        subjectManager.addNewSubject(english2);
        subjectManager.addNewSubject(english3);
        subjectManager.showSubject();
    }
    public Subject sub(String codeSub) {
        subjectManager.showSubject();
        Subject subject = null;
        for (Subject sub: subjectManager.getSubjectArrayList()) {
            if (sub.getCodeSubject().equals(codeSub)) {
                subject = sub;
                break;
            }
        }
        return subject;
    }

}

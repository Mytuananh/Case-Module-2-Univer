package cotroller.management;

import model.subject.Subject;
import storage.subjecttext.SubjectReadWriteFile;

import java.io.IOException;
import java.util.ArrayList;

public class SubjectManager {
    private static SubjectManager subjectManager = new SubjectManager();
    ArrayList<Subject> subjectArrayList = new ArrayList<>();
    SubjectReadWriteFile subjectReadWriteFile = SubjectReadWriteFile.getInstance();

    private SubjectManager() {
    }

    public static SubjectManager getInstance() {
        return subjectManager;
    }

    public SubjectManager(ArrayList<Subject> subjectArrayList) {
        this.subjectArrayList = subjectArrayList;
    }

    public ArrayList<Subject> getSubjectArrayList() {
        return subjectArrayList;
    }

    public void setSubjectArrayList(ArrayList<Subject> subjectArrayList) {
        this.subjectArrayList = subjectArrayList;
    }

    public void addNewSubject(Subject subject) {
        subjectArrayList.add(subject);
        try {
            subjectReadWriteFile.writeFile(subjectArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeSubject(String codeSubject) {
        Subject  subject = searchSubject(codeSubject);
        if (subject != null) {
            for (int i = 0; i < subjectArrayList.size(); i++) {
                if (subjectArrayList.get(i).equals(subject)) {
                    subjectArrayList.remove(i);
                }
            }
        } else {
            System.out.println("Not Found Subject!");
        }
        try {
            subjectReadWriteFile.writeFile(subjectArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void editSubject(String codeSubject, Subject subject) {
        Subject subject1 = searchSubject(codeSubject);
        if (subject1 != null) {
            for (int i = 0; i < subjectArrayList.size(); i++) {
                if (subjectArrayList.get(i).equals(subject1)) {
                    subjectArrayList.set(i, subject);
                }
            }
        } else {
            System.out.println("Not Found Subject!");
        }
        try {
            subjectReadWriteFile.writeFile(subjectArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Subject searchSubject(String codeSubject) {
        Subject subject = null;
        for (int i = 0; i < subjectArrayList.size(); i++) {
            if (subjectArrayList.get(i).getCodeSubject().equals(codeSubject)) {
                subject = subjectArrayList.get(i);
                break;
            }
        }
        return subject;
    }

    public void showSubject() {
        for (Subject sub: subjectArrayList) {
            System.out.println(sub);
        }
    }
}

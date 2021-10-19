package cotroller.teachermanager;

import model.teachers.EnglishTeacher;
import storage.teachertext.EnglishReadWriteFile;

import java.io.IOException;
import java.util.ArrayList;

public class EnglishTeacherManager {
    private static EnglishTeacherManager englishTeacherManager = new EnglishTeacherManager();
    ArrayList<EnglishTeacher> englishTeacherArrayList = new ArrayList<>();
    EnglishReadWriteFile englishReadWriteFile = EnglishReadWriteFile.getInstance();

    private EnglishTeacherManager() {
    }

    public static EnglishTeacherManager getInstance() {
        return englishTeacherManager;
    }

    public EnglishTeacherManager(ArrayList<EnglishTeacher> englishTeacherArrayList) {
        this.englishTeacherArrayList = englishTeacherArrayList;
    }

    public ArrayList<EnglishTeacher> getEnglishTeacherArrayList() {
        return englishTeacherArrayList;
    }

    public void setEnglishTeacherArrayList(ArrayList<EnglishTeacher> englishTeacherArrayList) {
        this.englishTeacherArrayList = englishTeacherArrayList;
    }

    public void addNewTeacher(EnglishTeacher englishTeacher) {
        englishTeacherArrayList.add(englishTeacher);
        try {
            englishReadWriteFile.writeFile(englishTeacherArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeTeacher(String codeTeacher) {
        EnglishTeacher englishTeacher = searchTeacher(codeTeacher);
        if (englishTeacher != null) {
            for (int i = 0; i < englishTeacherArrayList.size(); i++) {
                if (englishTeacherArrayList.get(i).equals(englishTeacher)) {
                    englishTeacherArrayList.remove(i);
                }
            }
        } else {
            System.out.println("Not Found EnglishTeacher!");
        }
        try {
            englishReadWriteFile.writeFile(englishTeacherArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void editEnglishTeacherArrayList(String codeTeacher, EnglishTeacher englishTeacher) {
        EnglishTeacher englishTeacher1 = searchTeacher(codeTeacher);
        if (englishTeacher1 != null) {
            for (int i = 0; i < englishTeacherArrayList.size(); i++) {
                if (englishTeacherArrayList.get(i).equals(englishTeacher1)) {
                    englishTeacherArrayList.set(i, englishTeacher);
                }
            }
        } else {
            System.out.println("Not Found EnglishTeacher!");
        }
        try {
            englishReadWriteFile.writeFile(englishTeacherArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public EnglishTeacher searchTeacher(String codeTeacher) {
        EnglishTeacher englishTeacher = null;
        for (int i = 0; i < englishTeacherArrayList.size(); i++) {
            if (englishTeacherArrayList.get(i).getCodeTeacher().equals(codeTeacher)) {
                englishTeacher = getEnglishTeacherArrayList().get(i);
                break;
            }
        }
        return englishTeacher;
    }
}

package cotroller.teachermanager;

import model.teachers.EnglishTeacher;

import java.util.ArrayList;

public class EnglishTeacherManager {
    ArrayList<EnglishTeacher> englishTeacherArrayList = new ArrayList<>();

    public EnglishTeacherManager(ArrayList<EnglishTeacher> englishTeacherArrayList) {
        this.englishTeacherArrayList = englishTeacherArrayList;
    }

    public ArrayList<EnglishTeacher> getEnglishTeacherArrayList() {
        return englishTeacherArrayList;
    }

    public void addNewStudent(EnglishTeacher englishTeacher) {
        englishTeacherArrayList.add(englishTeacher);
    }

    public void removeStudent(int index) {
        englishTeacherArrayList.remove(index);
    }

    public void setEnglishTeacherArrayList(int index, EnglishTeacher englishTeacher) {
        englishTeacherArrayList.set(index, englishTeacher);
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

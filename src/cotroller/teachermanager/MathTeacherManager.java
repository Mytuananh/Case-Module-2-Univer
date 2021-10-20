package cotroller.teachermanager;

import model.teachers.EnglishTeacher;
import model.teachers.MathTeacher;
import storage.teachertext.MathReadWriteFile;

import java.io.IOException;
import java.util.ArrayList;

public class MathTeacherManager {
    private static MathTeacherManager mathTeacherManager = new MathTeacherManager();
    ArrayList<MathTeacher> mathTeacherArrayList = new ArrayList<>();
    MathReadWriteFile mathReadWriteFile = MathReadWriteFile.getInstance();

    private MathTeacherManager() {
    }

    public static MathTeacherManager getInstance() {
        return mathTeacherManager;
    }

    public MathTeacherManager(ArrayList<MathTeacher> mathTeacherArrayList) {
        this.mathTeacherArrayList = mathTeacherArrayList;
    }

    public ArrayList<MathTeacher> getMathTeacherArrayList() {
        return mathTeacherArrayList;
    }

    public void setMathTeacherArrayList(ArrayList<MathTeacher> mathTeacherArrayList) {
        this.mathTeacherArrayList = mathTeacherArrayList;
    }

    public void addNewTeacher(MathTeacher mathTeacher) {
        mathTeacherArrayList.add(mathTeacher);
        try {
            mathReadWriteFile.writeFile(mathTeacherArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeTeacher(String codeTeacher) {
        if (mathTeacherArrayList != null) {
            for (int i = 0; i < mathTeacherArrayList.size(); i++) {
                if (mathTeacherArrayList.get(i).getCodeTeacher().equals(codeTeacher)) {
                    mathTeacherArrayList.remove(i);
                }
            }
        } else {
            System.out.println("Not Found MathTeacher!");
        }
        try {
            mathReadWriteFile.writeFile(mathTeacherArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void editMathTeacherArrayList(String codeTeacher, MathTeacher mathTeacher) {
        if (mathTeacherArrayList != null) {
            for (int i = 0; i < mathTeacherArrayList.size(); i++) {
                if (mathTeacherArrayList.get(i).getCodeTeacher().equals(codeTeacher)) {
                    mathTeacherArrayList.set(i, mathTeacher);
                }
            }
        } else {
            System.out.println("Not Found MathTeacher");
        }
        try {
            mathReadWriteFile.writeFile(mathTeacherArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MathTeacher searchTeacher(String codeTeacher) {
        MathTeacher mathTeacher = null;
        for (int i = 0; i < mathTeacherArrayList.size(); i++) {
            if (mathTeacherArrayList.get(i).getCodeTeacher().equals(codeTeacher)) {
                mathTeacher = getMathTeacherArrayList().get(i);
                break;
            }
        }
        return mathTeacher;
    }

    public void showMathTeacher() {
        for (MathTeacher math: mathTeacherArrayList) {
            System.out.println(math);
        }
    }
}

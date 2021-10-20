package cotroller.teachermanager;

import model.teachers.EnglishTeacher;
import model.teachers.HydraulicTeacher;
import storage.teachertext.HydraulicReadWriteFile;

import java.io.IOException;
import java.util.ArrayList;

public class HydraulicTeacherManager {
    private static HydraulicTeacherManager hydraulicTeacherManager = new HydraulicTeacherManager();
    ArrayList<HydraulicTeacher> hydraulicTeacherArrayList = new ArrayList<>();
    HydraulicReadWriteFile hydraulicReadWriteFile = HydraulicReadWriteFile.getInstance();

    private HydraulicTeacherManager() {
    }

    public static HydraulicTeacherManager getInstance() {
        return hydraulicTeacherManager;
    }
    public HydraulicTeacherManager(ArrayList<HydraulicTeacher> hydraulicTeacherArrayList) {
        this.hydraulicTeacherArrayList = hydraulicTeacherArrayList;
    }

    public ArrayList<HydraulicTeacher> getHydraulicTeacherArrayList() {
        return hydraulicTeacherArrayList;
    }

    public void setHydraulicTeacherArrayList(ArrayList<HydraulicTeacher> hydraulicTeacherArrayList) {
        this.hydraulicTeacherArrayList = hydraulicTeacherArrayList;
    }

    public void addNewTeacher(HydraulicTeacher hydraulicTeacher) {
        hydraulicTeacherArrayList.add(hydraulicTeacher);
        try {
            hydraulicReadWriteFile.writeFile(hydraulicTeacherArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeTeacher(String codeTeacher) {
       HydraulicTeacher hydraulicTeacher = searchTeacher(codeTeacher);
       if (hydraulicTeacher != null) {
           for (int i = 0; i < hydraulicTeacherArrayList.size(); i++) {
               if (hydraulicTeacherArrayList.get(i).equals(hydraulicTeacher)) {
                   hydraulicTeacherArrayList.remove(i);
               }
           }
       } else {
           System.out.println("Not Found HydraulicTeacher!");
       }
       try {
           hydraulicReadWriteFile.writeFile(hydraulicTeacherArrayList);
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

    public void editHydraulicTeacherArrayList(String codeTeacher, HydraulicTeacher hydraulicTeacher) {
        HydraulicTeacher hydraulicTeacher1 = searchTeacher(codeTeacher);
        if (hydraulicTeacher1 != null) {
            for (int i = 0; i < hydraulicTeacherArrayList.size(); i++) {
                if (hydraulicTeacherArrayList.get(i).equals(hydraulicTeacher1)) {
                    hydraulicTeacherArrayList.set(i,hydraulicTeacher);
                }
            }
        } else {
            System.out.println("Not Found HydraulicTeacher!");
        }
    }

    public HydraulicTeacher searchTeacher(String codeTeacher) {
        HydraulicTeacher hydraulicTeacher = null;
        for (int i = 0; i < hydraulicTeacherArrayList.size(); i++) {
            if (hydraulicTeacherArrayList.get(i).getCodeTeacher().equals(codeTeacher)) {
                hydraulicTeacher = getHydraulicTeacherArrayList().get(i);
                break;
            }
        }
        return hydraulicTeacher;
    }

    public void showHydraulicTeacher() {
        for (HydraulicTeacher hydraulic: hydraulicTeacherArrayList) {
            System.out.println(hydraulic);
        }
    }
}

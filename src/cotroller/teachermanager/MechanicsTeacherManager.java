package cotroller.teachermanager;

import model.teachers.EnglishTeacher;
import model.teachers.MechanicsTeacher;
import storage.teachertext.MechanicsReadWriteFile;

import java.io.IOException;
import java.util.ArrayList;

public class MechanicsTeacherManager {
    private static MechanicsTeacherManager mechanicsTeacherManager = new MechanicsTeacherManager();
    ArrayList<MechanicsTeacher> mechanicsTeacherArrayList = new ArrayList<>();
    MechanicsReadWriteFile mechanicsReadWriteFile = MechanicsReadWriteFile.getInstance();

    private MechanicsTeacherManager() {
    }

    public static MechanicsTeacherManager getInstance() {
        return mechanicsTeacherManager;
    }

    public MechanicsTeacherManager(ArrayList<MechanicsTeacher> mechanicsTeacherArrayList) {
        this.mechanicsTeacherArrayList = mechanicsTeacherArrayList;
    }

    public ArrayList<MechanicsTeacher> getMechanicsTeacherArrayList() {
        return mechanicsTeacherArrayList;
    }

    public void setMechanicsTeacherArrayList(ArrayList<MechanicsTeacher> mechanicsTeacherArrayList) {
        this.mechanicsTeacherArrayList = mechanicsTeacherArrayList;
    }

    public void addNewTeacher(MechanicsTeacher mechanicsTeacher) {
       mechanicsTeacherArrayList.add(mechanicsTeacher);
       try {
           mechanicsReadWriteFile.writeFile(mechanicsTeacherArrayList);
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

    public void removeTeacher(String codeTeacher) {
       MechanicsTeacher mechanicsTeacher = searchTeacher(codeTeacher);
       if (mechanicsTeacher != null) {
           for (int i = 0; i < mechanicsTeacherArrayList.size(); i++) {
               if (mechanicsTeacherArrayList.get(i).equals(mechanicsTeacher)) {
                   mechanicsTeacherArrayList.remove(i);
               }
           }
       } else {
           System.out.println("Not Found MechanicsTeacher!");
       }
       try {
           mechanicsReadWriteFile.writeFile(mechanicsTeacherArrayList);
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

    public void editMechanicsTeacherArrayList(String codeTeacher, MechanicsTeacher mechanicsTeacher) {
        MechanicsTeacher mechanicsTeacher1 = searchTeacher(codeTeacher);
        if (mechanicsTeacher1 != null) {
            for (int i = 0; i < mechanicsTeacherArrayList.size(); i++) {
                if (mechanicsTeacherArrayList.get(i).equals(mechanicsTeacher1)) {
                    mechanicsTeacherArrayList.set(i, mechanicsTeacher);
                }
            }
        } else {
            System.out.println("Not Found MechanicsTeacher!");
        }
        try {
            mechanicsReadWriteFile.writeFile(mechanicsTeacherArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MechanicsTeacher searchTeacher(String codeTeacher) {
        MechanicsTeacher mechanicsTeacher = null;
        for (int i = 0; i < mechanicsTeacherArrayList.size(); i++) {
            if (mechanicsTeacherArrayList.get(i).getCodeTeacher().equals(codeTeacher)) {
                mechanicsTeacher = getMechanicsTeacherArrayList().get(i);
                break;
            }
        }
        return mechanicsTeacher;
    }

    public void showMechanicsTeacher() {
        for (MechanicsTeacher mechanics: mechanicsTeacherArrayList) {
            System.out.println(mechanics);
        }
    }
}

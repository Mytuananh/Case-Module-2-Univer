package cotroller.teachermanager;

import model.teachers.HydraulicTeacher;

import java.util.ArrayList;

public class HydraulicTeacherManager {
    ArrayList<HydraulicTeacher> hydraulicTeacherArrayList = new ArrayList<>();

    public HydraulicTeacherManager(ArrayList<HydraulicTeacher> hydraulicTeacherArrayList) {
        this.hydraulicTeacherArrayList = hydraulicTeacherArrayList;
    }

    public ArrayList<HydraulicTeacher> getHydraulicTeacherArrayList() {
        return hydraulicTeacherArrayList;
    }

    public void addNewStudent(HydraulicTeacher hydraulicTeacher) {
        hydraulicTeacherArrayList.add(hydraulicTeacher);
    }

    public void removeStudent(int index) {
        hydraulicTeacherArrayList.remove(index);
    }

    public void setHydraulicTeacherArrayList(int index, HydraulicTeacher hydraulicTeacher) {
        hydraulicTeacherArrayList.set(index, hydraulicTeacher);
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
}

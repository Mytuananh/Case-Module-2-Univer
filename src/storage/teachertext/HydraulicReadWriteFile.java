package storage.teachertext;

import model.teachers.HydraulicTeacher;

import java.io.*;
import java.util.ArrayList;

public class HydraulicReadWriteFile implements Teacher<HydraulicTeacher> {
    private static HydraulicReadWriteFile hydraulicReadWriteFile;
    private HydraulicReadWriteFile() {
    }

    public static HydraulicReadWriteFile getInstance() {
        if (hydraulicReadWriteFile == null) {
            hydraulicReadWriteFile = new HydraulicReadWriteFile();
        }
        return hydraulicReadWriteFile;
    }
    @Override
    public ArrayList<HydraulicTeacher> readFile() throws IOException, ClassNotFoundException {
        File file = new File("hydraulic.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        if (file.length() > 0) {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();
            ArrayList<HydraulicTeacher> hydraulicTeacherArrayList = (ArrayList<HydraulicTeacher>) object;
            objectInputStream.close();
            fileInputStream.close();
            return hydraulicTeacherArrayList;
        }
        else return new ArrayList<>();
    }

    @Override
    public void writeFile(ArrayList<HydraulicTeacher> hydraulicTeacherArrayList) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("hydraulic.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(hydraulicTeacherArrayList);
        objectOutputStream.close();
        fileOutputStream.close();
    }
}

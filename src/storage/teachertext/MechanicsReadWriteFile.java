package storage.teachertext;

import model.teachers.MechanicsTeacher;

import java.io.*;
import java.util.ArrayList;

public class MechanicsReadWriteFile implements Teacher<MechanicsTeacher> {
    private static MechanicsReadWriteFile mechanicsReadWriteFile;
    private MechanicsReadWriteFile() {
    }

    public static MechanicsReadWriteFile getInstance() {
        if (mechanicsReadWriteFile == null) {
            mechanicsReadWriteFile = new MechanicsReadWriteFile();
        }
        return mechanicsReadWriteFile;
    }
    @Override
    public ArrayList<MechanicsTeacher> readFile() throws IOException, ClassNotFoundException {
        File file = new File("mechanics.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        if (file.length() > 0) {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();
            ArrayList<MechanicsTeacher> mechanicsTeacherArrayList = (ArrayList<MechanicsTeacher>) object;
            objectInputStream.close();
            fileInputStream.close();
            return mechanicsTeacherArrayList;
        }
        else return new ArrayList<>();
    }

    @Override
    public void writeFile(ArrayList<MechanicsTeacher> mechanicsTeacherArrayList) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("mechanics.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(mechanicsTeacherArrayList);
        objectOutputStream.close();
        fileOutputStream.close();
    }
}

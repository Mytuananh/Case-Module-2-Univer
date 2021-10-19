package storage.teacher;

import model.teachers.MathTeacher;

import java.io.*;
import java.util.ArrayList;

public class MathReadWriteFile implements Teacher<MathTeacher> {
    private static MathReadWriteFile mathReadWriteFile;
    private MathReadWriteFile() {
    }

    public static MathReadWriteFile getInstance() {
        if (mathReadWriteFile == null) {
            mathReadWriteFile = new MathReadWriteFile();
        }
        return mathReadWriteFile;
    }
    @Override
    public ArrayList<MathTeacher> readFile() throws IOException, ClassNotFoundException {
        File file = new File("math.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        if (file.length() > 0) {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();
            ArrayList<MathTeacher> mathTeacherArrayList = (ArrayList<MathTeacher>) object;
            objectInputStream.close();
            fileInputStream.close();
            return mathTeacherArrayList;
        }
        else return new ArrayList<>();
    }

    @Override
    public void writeFile(ArrayList<MathTeacher> mathTeacherArrayList) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("math.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(mathTeacherArrayList);
        objectOutputStream.close();
        fileOutputStream.close();
    }
}

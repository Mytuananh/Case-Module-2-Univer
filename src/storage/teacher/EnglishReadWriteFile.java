package storage.teacher;

import model.teachers.EnglishTeacher;

import java.io.*;
import java.util.ArrayList;

public class EnglishReadWriteFile implements Teacher<EnglishTeacher>{
    private static EnglishReadWriteFile englishReadWriteFile;
    private EnglishReadWriteFile() {
    }

    public static EnglishReadWriteFile getInstance() {
        if (englishReadWriteFile == null) {
            englishReadWriteFile = new EnglishReadWriteFile();
        }
        return englishReadWriteFile;
    }

    @Override
    public ArrayList<EnglishTeacher> readFile() throws IOException, ClassNotFoundException {
        File file = new File("english.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        if (file.length() > 0) {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();
            ArrayList<EnglishTeacher> englishTeacherArrayList = (ArrayList<EnglishTeacher>) object;
            objectInputStream.close();
            fileInputStream.close();
            return englishTeacherArrayList;
        }
        else return new ArrayList<>();
    }

    @Override
    public void writeFile(ArrayList<EnglishTeacher> englishTeacherArrayList) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("english.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(englishTeacherArrayList);
        objectOutputStream.close();
        fileOutputStream.close();
    }
}

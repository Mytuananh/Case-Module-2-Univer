package storage.subjecttext;

import model.subject.Subject;

import java.io.*;
import java.util.ArrayList;

public class SubjectReadWriteFile {
    private static SubjectReadWriteFile subjectReadWriteFile;
    private SubjectReadWriteFile() {
    }

    public static SubjectReadWriteFile getInstance() {
        if (subjectReadWriteFile == null) {
            subjectReadWriteFile = new SubjectReadWriteFile();
        }
        return subjectReadWriteFile;
    }

    public ArrayList<Subject> readFile() throws IOException, ClassNotFoundException {
        File file = new File("subject.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        if (file.length() > 0) {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();
            ArrayList<Subject> subjectArrayList = (ArrayList<Subject>) object;
            objectInputStream.close();
            fileInputStream.close();
            return subjectArrayList;
        }
        else return new ArrayList<>();
    }

    public void writeFile(ArrayList<Subject> subjectArrayList) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("subject.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(subjectArrayList);
        objectOutputStream.close();
        fileOutputStream.close();
    }
}

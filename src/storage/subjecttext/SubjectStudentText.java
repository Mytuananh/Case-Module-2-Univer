package storage.subjecttext;

import model.subject.Subject;
import model.subject.SubjectStudent;

import java.io.*;
import java.util.ArrayList;

public class SubjectStudentText {
    private static SubjectStudentText subjectStudentText;
    private SubjectStudentText() {
    }

    public static SubjectStudentText getInstance() {
        if (subjectStudentText == null) {
            subjectStudentText = new SubjectStudentText();
        }
        return subjectStudentText;
    }

    public ArrayList<SubjectStudent> readFile() throws IOException, ClassNotFoundException {
        File file = new File("subjectStudent.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        if (file.length() > 0) {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();
            ArrayList<SubjectStudent> subjectStudentArrayList = (ArrayList<SubjectStudent>) object;
            objectInputStream.close();
            fileInputStream.close();
            return subjectStudentArrayList;
        }
        else return new ArrayList<>();
    }

    public void writeFile(ArrayList<SubjectStudent> subjectStudentArrayList) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("subjectStudent.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(subjectStudentArrayList);
        objectOutputStream.close();
        fileOutputStream.close();
    }
}

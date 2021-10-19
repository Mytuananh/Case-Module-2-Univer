package storage.studenttext;

import model.students.AdministrationStudent;

import java.io.*;
import java.util.ArrayList;

public class AdministrationReadWriteFile implements Student<AdministrationStudent>{
    private static AdministrationReadWriteFile administrationReadWriteFile;
    private AdministrationReadWriteFile() {
    }

    public static AdministrationReadWriteFile getInstance() {
        if (administrationReadWriteFile == null) {
            administrationReadWriteFile = new AdministrationReadWriteFile();
        }
        return administrationReadWriteFile;
    }
    @Override
    public ArrayList<AdministrationStudent> readFile() throws IOException, ClassNotFoundException {
        File file = new File("administration.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        if (file.length() > 0) {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();
            ArrayList<AdministrationStudent> administrationStudentArrayList = (ArrayList<AdministrationStudent>) object;
            objectInputStream.close();
            fileInputStream.close();
            return administrationStudentArrayList;
        }
        else return new ArrayList<>();
    }

    @Override
    public void writeFile(ArrayList<AdministrationStudent> administrationStudentArrayList) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("administration.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(administrationStudentArrayList);
        objectOutputStream.close();
        fileOutputStream.close();
    }
}

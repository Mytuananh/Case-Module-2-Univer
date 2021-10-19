package storage.studenttext;

import model.students.ConstructionStudent;

import java.io.*;
import java.util.ArrayList;

public class ConstructionReadWriteFile implements Student<ConstructionStudent>{
    private static ConstructionReadWriteFile constructionReadWriteFile;
    private ConstructionReadWriteFile() {
    }

    public static ConstructionReadWriteFile getInstance() {
        if (constructionReadWriteFile == null) {
            constructionReadWriteFile = new ConstructionReadWriteFile();
        }
        return constructionReadWriteFile;
    }
    @Override
    public ArrayList<ConstructionStudent> readFile() throws IOException, ClassNotFoundException {
        File file = new File("freshman.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        if (file.length() > 0) {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();
            ArrayList<ConstructionStudent> constructionStudentArrayList = (ArrayList<ConstructionStudent>) object;
            objectInputStream.close();
            fileInputStream.close();
            return constructionStudentArrayList;
        }
        else return new ArrayList<>();

    }

    @Override
    public void writeFile(ArrayList<ConstructionStudent> constructionStudentArrayList) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("freshman.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(constructionStudentArrayList);
        objectOutputStream.close();
        fileOutputStream.close();

    }
}

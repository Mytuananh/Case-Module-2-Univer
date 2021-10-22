package storage.userText;

import model.user.User;

import java.io.*;
import java.util.ArrayList;

public class UserFile {
    private static final UserFile userFile = new UserFile();
    private UserFile() {
    }

    public static UserFile getInstance() {
        return userFile;
    }
    public ArrayList<User> readFile() throws IOException, ClassNotFoundException {
        File file = new File("userList.txt");
        if (!file.exists()){
            file.createNewFile();
        }
        if (file.length() >0){
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();
            ArrayList<User> list = (ArrayList<User>) object;
            objectInputStream.close();
            fileInputStream.close();
            return list;
        }
        else return new ArrayList<>();
    }


    public void writeFile(ArrayList<User> users) throws IOException{
        FileOutputStream fileOutputStream = new FileOutputStream("userList.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(users);
        objectOutputStream.close();
        fileOutputStream.close();
    }
}


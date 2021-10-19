package storage.studenttext;

import model.students.AccountantStudent;

import java.io.*;
import java.util.ArrayList;

public class AccountantReadWriteFile implements Student<AccountantStudent> {
    private static AccountantReadWriteFile accountantReadWriteFile;
    private AccountantReadWriteFile() {
    }

    public static AccountantReadWriteFile getInstance() {
      if (accountantReadWriteFile == null) {
          accountantReadWriteFile = new AccountantReadWriteFile();
      }
      return accountantReadWriteFile;
    }
    @Override
    public ArrayList<AccountantStudent> readFile() throws IOException, ClassNotFoundException {
        File file = new File("accountant.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        if (file.length() > 0) {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();
            ArrayList<AccountantStudent> accountantStudentArrayList = (ArrayList<AccountantStudent>) object;
            objectInputStream.close();
            fileInputStream.close();
            return accountantStudentArrayList;
        }
        else return new ArrayList<>();
    }

    @Override
    public void writeFile(ArrayList<AccountantStudent> accountantStudentArrayList) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("accountant.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(accountantStudentArrayList);
        objectOutputStream.close();
        fileOutputStream.close();
    }
}

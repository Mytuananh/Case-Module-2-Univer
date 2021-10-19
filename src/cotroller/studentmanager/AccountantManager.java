package cotroller.studentmanager;

import model.students.AccountantStudent;
import storage.studenttext.AccountantReadWriteFile;

import java.io.IOException;
import java.util.ArrayList;

public class AccountantManager {
    private static AccountantManager accountantManager = new AccountantManager();
    ArrayList<AccountantStudent> accountantStudentArrayList = new ArrayList<>();
    AccountantReadWriteFile accountantReadWriteFile = AccountantReadWriteFile.getInstance();

    private AccountantManager() {
    }

    public static AccountantManager getInstance() {
        return accountantManager;
    }


    public AccountantManager(ArrayList<AccountantStudent> accountantStudentArrayList) {
        this.accountantStudentArrayList = accountantStudentArrayList;
    }

    public ArrayList<AccountantStudent> getAccountantStudentArrayList() {
        return accountantStudentArrayList;
    }

    public void setAccountantStudentArrayList(ArrayList<AccountantStudent> accountantStudentArrayList) {
        this.accountantStudentArrayList = accountantStudentArrayList;
    }

    public void addNewStudent(AccountantStudent accountantStudent) {
        accountantStudentArrayList.add(accountantStudent);
        try {
            accountantReadWriteFile.writeFile(accountantStudentArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeStudent(String codeStudent) {
        AccountantStudent accountantStudent = searchStudent(codeStudent);
        if (accountantStudent != null) {
            for (int i = 0; i < accountantStudentArrayList.size(); i++) {
                if (accountantStudentArrayList.get(i).equals(accountantStudent)) {
                    accountantStudentArrayList.remove(i);
                }
            }
        } else {
            System.out.println("Not Found AccountantStudent!");
        }
        try {
            accountantReadWriteFile.writeFile(accountantStudentArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void editAccountantStudentArrayList(String codeStudent, AccountantStudent accountantStudent) {
        AccountantStudent accountantStudent1 = searchStudent(codeStudent);
        if (accountantStudent1 != null) {
            for (int i = 0; i < accountantStudentArrayList.size(); i++) {
                if (accountantStudentArrayList.get(i).equals(accountantStudent1)) {
                    accountantStudentArrayList.set(i, accountantStudent);
                }
            }
        } else {
            System.out.println("Not Found AccountantStudent!");
        }
        try {
            accountantReadWriteFile.writeFile(accountantStudentArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public AccountantStudent searchStudent(String codeStudent) {
        AccountantStudent accountantStudent = null;
        for (int i = 0; i < accountantStudentArrayList.size(); i++) {
            if (accountantStudentArrayList.get(i).getCodeStudent().equals(codeStudent)) {
                accountantStudent = getAccountantStudentArrayList().get(i);
                break;
            }
        }
        return accountantStudent;
    }
}

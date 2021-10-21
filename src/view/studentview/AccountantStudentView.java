package view.studentview;

import cotroller.studentmanager.AccountantManager;
import model.students.AccountantStudent;
import storage.studenttext.AccountantReadWriteFile;


import java.io.IOException;
import java.util.Scanner;

public class AccountantStudentView {
    private static final AccountantStudentView accountantStudentView = new AccountantStudentView();

    private AccountantStudentView() {
    }

    public static AccountantStudentView getInstance() {
        return accountantStudentView;
    }
    public void runAccountant() {
        AccountantManager accountantManager = AccountantManager.getInstance();

        try {
            accountantManager.setAccountantStudentArrayList(AccountantReadWriteFile.getInstance().readFile());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        int choice = -2;
        while (choice != 0) {
            System.out.println("Danh sách sinh viên ngành Kế Toán");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Sửa thông tin sinh viên");
            System.out.println("3. Xóa sinh viên");
            System.out.println("4. Tìm kiếm sinh viên");
            System.out.println("5. Danh sách sinh viên");
            System.out.println("0. Quay lại");

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    System.out.println("1. Thêm sinh viên");
                    addStudent(accountantManager);
                    break;
                }
                case 2: {
                    System.out.println("2. Sửa thông tin sinh viên");
                    editStudent(accountantManager);
                    break;
                }
                case 3: {
                    System.out.println("3. Xóa sinh viên");
                    removeStudent(accountantManager);
                    break;
                }
                case 4: {
                    System.out.println("4. Tìm kiếm sinh viên");
                    searchStudent(accountantManager);
                    break;
                }
                case 5: {
                    System.out.println("5. Danh sách sinh viên");
                    accountantManager.showAccountantStudent();
                    break;
                }
                case 0:
            }
        }
    }

    public static AccountantStudent inputStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên: ");
        String name = scanner.nextLine();

        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Nhập ngày tháng năm sinh: ");
        String dateOfBirth = scanner1.nextLine();

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Nhập mã sinh viên: ");
        String codeStudent = scanner2.nextLine();

        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Nhập tên lớp: ");
        String className = scanner3.nextLine();

        Scanner scanner4 = new Scanner(System.in);
        System.out.println("Nhập quê quán: ");
        String homeTown = scanner4.nextLine();

        return new AccountantStudent(name, dateOfBirth, codeStudent, className, homeTown);
    }
    private void addStudent(AccountantManager accountantManager) {

        accountantManager.addNewStudent(inputStudent());
    }
    private void editStudent(AccountantManager accountantManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã sinh viên: ");
        String codeStudent = scanner.nextLine();
        accountantManager.editAccountantStudentArrayList(codeStudent, inputStudent());
    }
    private void removeStudent(AccountantManager accountantManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã sinh viên: ");
        String codeStudent = scanner.nextLine();
        accountantManager.removeStudent(codeStudent);
    }
    private void searchStudent(AccountantManager accountantManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã sinh viên: ");
        String codeStudent = scanner.nextLine();
        AccountantStudent accountantStudent = accountantManager.searchStudent(codeStudent);
        System.out.println(accountantStudent);
    }
}

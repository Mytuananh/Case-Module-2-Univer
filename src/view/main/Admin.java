package view.main;

import view.studentview.AllStudentView;
import view.subjectview.AllSubjectView;
import view.teacherview.AllTeacherView;

import java.util.Scanner;

public class Admin {
    private static final Admin admin = new Admin();
    private Admin() {
    }
    public static Admin getInstance() {
        return admin;
    }
   private static final AllStudentView allStudentView = new AllStudentView();
    private static final AllTeacherView allTeacherView = new AllTeacherView();
    private static final AllSubjectView allSubjectView = new AllSubjectView();

    public void runAdmin() {


        int choice = -2;

        while (choice != 0) {
            System.out.println("-------Quản lý nhà trường-------");
            System.out.println("1. Quản lý sinh viên");
            System.out.println("2. Quản lý giảng viên");
            System.out.println("3. Kiểm tra danh sách môn học");
            System.out.println("0. Quay lại");

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    System.out.println("1. Quản lý sinh viên");
                    allStudentView.runStudent();
                    break;
                }
                case 2: {
                    System.out.println("2. Quản lý giảng viên");
                    allTeacherView.runTeacher();
                    break;
                }
                case 3: {
                    System.out.println("3. Kiểm tra danh sách môn học");
                    allSubjectView.runAllSub();
                    break;
                }
                case 0:

            }
        }
    }
}

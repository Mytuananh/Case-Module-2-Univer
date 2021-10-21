package view.main;

import view.main.student.StudentMenuAll;
import view.main.teacher.TeacherMenuAll;

import java.util.Scanner;

public class MenuAll {
    private static final Admin admin = new Admin();
    private static final StudentMenuAll studentMenuAll = new StudentMenuAll();
    private static final TeacherMenuAll teacherMenuAll = new TeacherMenuAll();

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice = -2;

        while (choice != 0) {
            System.out.println("----------Hệ thống quản lý----------");
            System.out.println("1. Dành cho admin");
            System.out.println("2. Dành cho sinh viên");
            System.out.println("3. Dành cho giảng viên");
            System.out.println("0. Quay lại");

            choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    System.out.println("1. Dành cho admin");
                    admin.runAdmin();
                    break;
                }
                case 2: {
                    System.out.println("2. Dành cho sinh viên");
                    studentMenuAll.runAll();
                    break;
                }
                case 3: {
                    System.out.println("3. Dành cho giảng viên");
                    teacherMenuAll.runAll();
                    break;
                }
                case 0:
            }
        }
    }
}

package view.teacherview;

import java.util.Scanner;

public class AllTeacherView {
    public void runTeacher() {
        EnglishTeacherView englishTeacherView = EnglishTeacherView.getInstance();
        HydraulicTeacherView hydraulicTeacherView = HydraulicTeacherView.getInstance();
        MathTeacherView mathTeacherView = MathTeacherView.getInstance();
        MechanicsTeacherView mechanicsTeacherView = MechanicsTeacherView.getInstance();
        int choice = -1;

        while (choice != -1) {
            System.out.println("-----Quản lý giảng viên-----");
            System.out.println("1. Giảng viên bộ môn tiếng anh");
            System.out.println("2. Giảng viên bộ môn thủy công");
            System.out.println("3. Giảng viên bộ môn toán");
            System.out.println("4. Giảng viên bộ môn cơ học");
            System.out.println("0. Quay lại");
            Scanner scanner = new Scanner(System.in);
            switch (choice) {
                case 1: {
                    System.out.println("1. Giảng viên bộ môn tiếng anh");
                    englishTeacherView.runEnglish();
                    break;
                }
                case 2: {
                    System.out.println("2. Giảng viên bộ môn thủy công");
                    hydraulicTeacherView.runHydraulic();
                    break;
                }
                case 3: {
                    System.out.println("3. Giảng viên bộ môn toán");
                    mathTeacherView.runMath();
                    break;
                }
                case 4: {
                    System.out.println("4. Giảng viên bộ môn cơ học");
                    mechanicsTeacherView.runMechanics();
                    break;
                }
                case 0: {
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("Không tìm thấy yêu cầu!");
                    break;
                }
            }
        }
    }


}

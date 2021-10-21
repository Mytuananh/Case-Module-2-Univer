package view.main.teacher;

import java.util.Scanner;

public class TeacherMenuAll {
    private static final EnglishTeacherSub englishTeacherSub = new EnglishTeacherSub();
    private static final HydraulicTeacherSub hydraulicTeacherSub = new HydraulicTeacherSub();
    private static final MathTeacherSub mathTeacherSub = new MathTeacherSub();
    private static final MechanicsTeacherSub mechanicsTeacherSub = new MechanicsTeacherSub();

    public void runAll() {
        Scanner scanner = new Scanner(System.in);
        int choice = -2;

        while (choice != 0) {
            System.out.println("Danh sách sinh viên đăng ký và lương");
            System.out.println("1. Giảng viên bộ môn tiếng anh");
            System.out.println("2. Giảng viên bộ môn thủy công");
            System.out.println("3. Giảng viên bộ môn toán");
            System.out.println("4. Giảng viên bộ môn cơ học");
            System.out.println("0. Quay lại");

            choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    System.out.println("1. Giảng viên bộ môn tiếng anh");
                    englishTeacherSub.runView();
                    break;
                }
                case 2: {
                    System.out.println("2. Giảng viên bộ môn thủy công");
                    hydraulicTeacherSub.runView();
                    break;
                }
                case 3: {
                    System.out.println("3. Giảng viên bộ môn toán");
                    mathTeacherSub.runView();
                    break;
                }
                case 4: {
                    System.out.println("4. Giảng viên bộ môn cơ học");
                    mechanicsTeacherSub.runView();
                    break;
                }
                case 0:
            }
        }
    }
}

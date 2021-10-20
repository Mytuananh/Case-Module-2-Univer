package view.teacherview;



import cotroller.teachermanager.MathTeacherManager;
import model.teachers.MathTeacher;
import storage.teachertext.MathReadWriteFile;

import java.io.IOException;
import java.util.Scanner;

public class MathTeacherView {
    private static MathTeacherView mathTeacherView = new MathTeacherView();
    private MathTeacherView() {
    }

    public static MathTeacherView getInstance() {
        return mathTeacherView;
    }
    public void runMath() {
        MathTeacherManager mathTeacherManager = MathTeacherManager.getInstance();
        try {
            mathTeacherManager.setMathTeacherArrayList(MathReadWriteFile.getInstance().readFile());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        int choice = -1;
        while (choice != -1) {
            System.out.println("Danh sách giảng viên bộ môn Toán!");
            System.out.println("1. Thêm giảng viên");
            System.out.println("2. Sửa thông tin giảng viên");
            System.out.println("3. Xóa giảng viên");
            System.out.println("4. Tìm kiếm giảng viên");
            System.out.println("5. Danh sách giảng viên");
            System.out.println("0. Quay lại");

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    System.out.println("1. Thêm giảng viên");
                    addTeacher(mathTeacherManager);
                    break;
                }
                case 2: {
                    System.out.println("2. Sửa thông tin giảng viên");
                    editTeacher(mathTeacherManager);
                    break;
                }
                case 3: {
                    System.out.println("3. Xóa giảng viên");
                    removeTeacher(mathTeacherManager);
                    break;
                }
                case 4: {
                    System.out.println("4. Tìm kiếm giảng viên");
                    searchTeacher(mathTeacherManager);
                    break;
                }
                case 5: {
                    System.out.println("5. Danh sách giảng viên");
                    mathTeacherManager.showMathTeacher();
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

    public static MathTeacher inputTeacher() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên: ");
        String name = scanner.nextLine();

        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Nhập ngày tháng năm sinh: ");
        String dateOfBirth = scanner1.nextLine();

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Nhập mã giảng viên: ");
        String codeTeacher = scanner2.nextLine();

        Scanner scanner4 = new Scanner(System.in);
        System.out.println("Nhập quê quán: ");
        String homeTown = scanner4.nextLine();

        return new MathTeacher(name, dateOfBirth, codeTeacher, homeTown);
    }
    private void addTeacher(MathTeacherManager mathTeacherManager) {
        inputTeacher();
        mathTeacherManager.addNewTeacher(inputTeacher());
    }
    private void editTeacher(MathTeacherManager mathTeacherManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã giảng viên: ");
        String codeTeacher = scanner.nextLine();
        mathTeacherManager.editMathTeacherArrayList(codeTeacher, inputTeacher());
    }
    private void removeTeacher(MathTeacherManager mathTeacherManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã giảng viên: ");
        String codeTeacher = scanner.nextLine();
        mathTeacherManager.removeTeacher(codeTeacher);
    }
    private void searchTeacher(MathTeacherManager mathTeacherManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã giảng viên: ");
        String codeTeacher = scanner.nextLine();
        mathTeacherManager.searchTeacher(codeTeacher);
    }
}

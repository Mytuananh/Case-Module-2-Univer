package view.teacherview;


import cotroller.teachermanager.EnglishTeacherManager;
import model.teachers.EnglishTeacher;
import storage.teachertext.EnglishReadWriteFile;

import java.io.IOException;
import java.util.Scanner;

public class EnglishTeacherView {
    private static EnglishTeacherView englishTeacherView = new EnglishTeacherView();
    private EnglishTeacherView() {
    }

    public  static EnglishTeacherView getInstance() {
        return englishTeacherView;
    }
    public void runEnglish() {
        EnglishTeacherManager englishTeacherManager = EnglishTeacherManager.getInstance();
        try {
            englishTeacherManager.setEnglishTeacherArrayList(EnglishReadWriteFile.getInstance().readFile());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        int choice = -2;
        while (choice != -1) {
            System.out.println("Danh sách giảng viên bộ môn English!");
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
                    addTeacher(englishTeacherManager);
                    break;
                }
                case 2: {
                    System.out.println("2. Sửa thông tin giảng viên");
                    editTeacher(englishTeacherManager);
                    break;
                }
                case 3: {
                    System.out.println("3. Xóa giảng viên");
                    removeTeacher(englishTeacherManager);
                    break;
                }
                case 4: {
                    System.out.println("4. Tìm kiếm giảng viên");
                    searchTeacher(englishTeacherManager);
                    break;
                }
                case 5: {
                    System.out.println("5. Danh sách giảng viên");
                    englishTeacherManager.showEnglishTeacher();
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

    public static EnglishTeacher inputTeacher() {
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

        return new EnglishTeacher(name, dateOfBirth, codeTeacher, homeTown);
    }
    private void addTeacher(EnglishTeacherManager englishTeacherManager) {
        englishTeacherManager.addNewTeacher(inputTeacher());
    }
    private void editTeacher(EnglishTeacherManager englishTeacherManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã giảng viên: ");
        String codeTeacher = scanner.nextLine();
        englishTeacherManager.editEnglishTeacherArrayList(codeTeacher, inputTeacher());
    }
    private void removeTeacher(EnglishTeacherManager englishTeacherManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã giảng viên: ");
        String codeTeacher = scanner.nextLine();
        englishTeacherManager.removeTeacher(codeTeacher);
    }
    private void searchTeacher(EnglishTeacherManager englishTeacherManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã giảng viên: ");
        String codeTeacher = scanner.nextLine();
        EnglishTeacher englishTeacher = englishTeacherManager.searchTeacher(codeTeacher);
        System.out.println(englishTeacher);
    }
}

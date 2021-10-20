package view.teacherview;

import cotroller.teachermanager.MathTeacherManager;
import cotroller.teachermanager.MechanicsTeacherManager;
import model.teachers.MathTeacher;
import model.teachers.MechanicsTeacher;
import storage.teachertext.MathReadWriteFile;
import storage.teachertext.MechanicsReadWriteFile;

import java.io.IOException;
import java.util.Scanner;

public class MechanicsTeacherView {
    private static MechanicsTeacherView mechanicsTeacherView = new MechanicsTeacherView();
    private MechanicsTeacherView() {
    }

    public static MechanicsTeacherView getInstance() {
        return mechanicsTeacherView;
    }
    public void runMechanics() {
        MechanicsTeacherManager mechanicsTeacherManager = MechanicsTeacherManager.getInstance();
        try {
            mechanicsTeacherManager.setMechanicsTeacherArrayList(MechanicsReadWriteFile.getInstance().readFile());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        int choice = -2;
        while (choice != -1) {
            System.out.println("Danh sách giảng viên bộ môn Cơ Học!");
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
                    addTeacher(mechanicsTeacherManager);
                    break;
                }
                case 2: {
                    System.out.println("2. Sửa thông tin giảng viên");
                    editTeacher(mechanicsTeacherManager);
                    break;
                }
                case 3: {
                    System.out.println("3. Xóa giảng viên");
                    removeTeacher(mechanicsTeacherManager);
                    break;
                }
                case 4: {
                    System.out.println("4. Tìm kiếm giảng viên");
                    searchTeacher(mechanicsTeacherManager);
                    break;
                }
                case 5: {
                    System.out.println("5. Danh sách giảng viên");
                    mechanicsTeacherManager.showMechanicsTeacher();
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

    public static MechanicsTeacher inputTeacher() {
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

        return new MechanicsTeacher(name, dateOfBirth, codeTeacher, homeTown);
    }
    private void addTeacher(MechanicsTeacherManager mechanicsTeacherManager) {
        mechanicsTeacherManager.addNewTeacher(inputTeacher());
    }
    private void editTeacher(MechanicsTeacherManager mechanicsTeacherManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã giảng viên: ");
        String codeTeacher = scanner.nextLine();
        mechanicsTeacherManager.editMechanicsTeacherArrayList(codeTeacher, inputTeacher());
    }
    private void removeTeacher(MechanicsTeacherManager mechanicsTeacherManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã giảng viên: ");
        String codeTeacher = scanner.nextLine();
       mechanicsTeacherManager.removeTeacher(codeTeacher);
    }
    private void searchTeacher(MechanicsTeacherManager mechanicsTeacherManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã giảng viên: ");
        String codeTeacher = scanner.nextLine();
        mechanicsTeacherManager.searchTeacher(codeTeacher);
    }
}

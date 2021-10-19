package view.studentview;



import cotroller.studentmanager.ConstructionManager;
import model.students.ConstructionStudent;
import storage.studenttext.ConstructionReadWriteFile;

import java.io.IOException;
import java.util.Scanner;

public class ConstructionStudentView {
    public void runConstruction() {
        ConstructionManager constructionManager = ConstructionManager.getInstance();
        try {
            constructionManager.setConstructionStudentArrayList(ConstructionReadWriteFile.getInstance().readFile());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        int choice = -1;
        while (choice != 0) {
            System.out.println("Danh sách sinh viên ngành Công Trình");
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
                    addStudent(constructionManager);
                    break;
                }
                case 2: {
                    System.out.println("2. Sửa thông tin sinh viên");
                    editStudent(constructionManager);
                    break;
                }
                case 3: {
                    System.out.println("3. Xóa sinh viên");
                    removeStudent(constructionManager);
                    break;
                }
                case 4: {
                    System.out.println("4. Tìm kiếm sinh viên");
                    searchStudent(constructionManager);
                    break;
                }
                case 5: {
                    System.out.println("5. Danh sách sinh viên");
                    constructionManager.showConstructionStudent();
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

    public static ConstructionStudent inputStudent() {
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

        return new ConstructionStudent(name, dateOfBirth, codeStudent, className, homeTown);
    }
    private void addStudent(ConstructionManager constructionManager) {
        inputStudent();
        constructionManager.addNewStudent(inputStudent());
    }
    private void editStudent(ConstructionManager constructionManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã sinh viên: ");
        String codeStudent = scanner.nextLine();
        constructionManager.editConstructionStudentArrayList(codeStudent, inputStudent());
    }
    private void removeStudent(ConstructionManager constructionManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã sinh viên: ");
        String codeStudent = scanner.nextLine();
        constructionManager.removeStudent(codeStudent);
    }
    private void searchStudent(ConstructionManager constructionManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã sinh viên: ");
        String codeStudent = scanner.nextLine();
        constructionManager.searchStudent(codeStudent);
    }
}

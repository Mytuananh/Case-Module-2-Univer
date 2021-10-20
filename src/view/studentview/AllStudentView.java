package view.studentview;

import java.util.Scanner;

public class AllStudentView {
    public void runStudent() {
        AccountantStudentView accountantStudentView = AccountantStudentView.getInstance();
        AdministrationStudentView administrationStudentView = AdministrationStudentView.getInstance();
        ConstructionStudentView constructionStudentView = ConstructionStudentView.getInstance();

        int choice = -1;

        while (choice != -1) {
            System.out.println("-----Quản lý sinh viên-----");
            System.out.println("1. Sinh viên ngành Kế Toán");
            System.out.println("2. Sinh viên ngành Quản Lý");
            System.out.println("3. Sinh viên ngành công trình");
            System.out.println("0. Quay lại");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

        switch (choice) {
            case 1 : {
                System.out.println("1. Sinh viên ngành Kế Toán");
                accountantStudentView.runAccountant();
                break;
            }
            case 2: {
                System.out.println("2. Sinh viên ngành Quản Lý");
                administrationStudentView.runAdministration();
                break;
            }
            case 3: {
                System.out.println("3. Sinh viên ngành công trình");
                constructionStudentView.runConstruction();
                break;
            }
            case 0: {
                System.exit(0);
                break;
            }
            default: {
                System.out.println("Không tìm thấy yêu cầu!");
            }


        }

        }
    }
}

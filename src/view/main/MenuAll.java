package view.main;

import cotroller.management.ManagerUser;
import model.user.User;
import storage.userText.UserFile;
import view.main.student.StudentMenuAll;


import java.io.IOException;
import java.util.Scanner;

public class MenuAll {
    ManagerUser managerUser = ManagerUser.getInstance();
    private static final Admin admin = Admin.getInstance();
    private static final StudentMenuAll studentMenuAll = StudentMenuAll.getInstance();
    private static final String STUDENT = "Student";
    private static final String ADMIN = "AnhTuan";
    public void run() {
        try {
            managerUser.setUserArrayList(UserFile.getInstance().readFile());
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        userAdmin();
        Scanner scanner = new Scanner(System.in);
        int choice = -2;

        while (choice != 0) {
            System.out.println("----------Hệ thống quản lý----------");
            System.out.println("1. Đăng nhập");
            System.out.println("2. Đăng ký");
            System.out.println("0. Thoát");

            choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    System.out.println("1. Đăng nhập");
                    isLogin();
                    break;
                }
                case 2: {
                    System.out.println("2. Đăng ký");
                    managerUser.addNewUser(creatUser());
                    System.out.println("TẠO TÀI KHOẢN THÀNH CÔNG");
                    break;
                }
                case 0: {
                    System.exit(0);
                }
            }
        }
    }
    private void userAdmin() {
        managerUser.addNewUser(new User("AnhTuan", "23101997", ADMIN));
    }
    private void isLogin() {
        System.out.println("ĐĂNG NHẬP");
        System.out.print("Tài khoản : ");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine();
        System.out.print("Mật khẩu : ");
        String password = scanner.nextLine();
        User userLogin = new User(userName, password);
        boolean isLogin = managerUser.isLogin(userLogin);
        if (isLogin) {
            User user = managerUser.findUser(userName);
            if (user.getRole().equalsIgnoreCase(ADMIN)) {
               admin.runAdmin();
            } else {
                studentMenuAll.runAll();
            }
        } else {
            System.out.println("TÀI KHOẢN HOẶC MẬT KHẨU KHÔNG ĐÚNG VUI LÒNG THỬ LẠI!");
        }
    }
    private static User creatUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ĐĂNG KÝ");
        System.out.print("Nhập tên đăng nhập: ");
        String user = scanner.nextLine();
        System.out.print("Nhập mật khẩu: ");
        String passWord = scanner.nextLine();
        return new User(user, passWord, STUDENT);
    }
}

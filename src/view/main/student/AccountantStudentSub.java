package view.main.student;


import cotroller.studentmanager.AccountantManager;
import model.subject.Subject;
import storage.studenttext.AccountantReadWriteFile;
import view.subjectview.English;
import view.subjectview.Math;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AccountantStudentSub {
    private static final English english = English.getInstance();
    private static final Math math = Math.getInstance();
    ArrayList<Subject> subjectList = new ArrayList<>();


    public void runView() {
        AccountantManager accountantManager = AccountantManager.getInstance();
        try {
            accountantManager.setAccountantStudentArrayList(AccountantReadWriteFile.getInstance().readFile());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        int choice = -2;

        while (choice != 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập mã sinh viên: ");
            String codeStudent = scanner.nextLine();
            System.out.println( accountantManager.searchStudent(codeStudent));
            System.out.println("-----Sinh viên khoa kế toán-----");
            System.out.println("1. Đăng ký học");
            System.out.println("2. Xem học phí");
            System.out.println("0. Quay lại");

            choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    System.out.println("1. Đăng ký học");
                    creatSub();
                    break;
                }
                case 2: {
                    System.out.println("2. Xem học phí");
                    double total = 0;
                    for (Subject sub : subjectList) {
                        total += sub.getTuition();
                    }
                    System.out.println("Học phí của học viên là:" + total);
                    break;
                }
                case 0:
            }
        }
    }

    private void creatSub() {
        int choose = -2;

        while (choose != 0) {
            System.out.println("-----Danh sách đăng ký học-----");
            System.out.println("1. Đăng ký bộ môn tiếng anh");
            System.out.println("2. Đăng ký bộ môn toán");
            System.out.println("0. Quay lại");

            Scanner scanner = new Scanner(System.in);
            choose = scanner.nextInt();

            switch (choose) {
                case 1: {
                    System.out.println("1. Đăng ký bộ môn tiếng anh");
                    creatEng();

                }

                case 2: {
                    System.out.println("3. Đăng ký bộ môn toán");
                    creatMath();
                    break;
                }
                case 0:

            }
        }
    }

    private void creatEng() {
        english.runEnglish();
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Nhập mã môn học: ");
        String codeSub = scanner1.nextLine();
        subjectList.add(english.sub(codeSub));
    }

    private void creatMath() {
        math.runMath();
        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Nhập mã môn học: ");
        String codeSub2 = scanner3.nextLine();
        subjectList.add(math.sub(codeSub2));
    }
}
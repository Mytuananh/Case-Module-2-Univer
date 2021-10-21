package view.main.student;


import cotroller.management.SubjectStudentManager;
import cotroller.studentmanager.ConstructionManager;
import model.students.ConstructionStudent;
import model.subject.Subject;
import model.subject.SubjectStudent;
import storage.studenttext.ConstructionReadWriteFile;
import storage.subjecttext.SubjectStudentText;
import view.subjectview.English;
import view.subjectview.Hydraulic;
import view.subjectview.Math;
import view.subjectview.Mechanics;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ConstructionStudentSub {
    private static final English english = English.getInstance();
    private static final Hydraulic hydraulic = Hydraulic.getInstance();
    private static final Math math = Math.getInstance();
    private static final Mechanics mechanics = Mechanics.getInstance();
    private static ConstructionStudent constructionStudent;
    SubjectStudentManager subjectStudentManager = SubjectStudentManager.getInstance();
    ArrayList<Subject> subjectList = new ArrayList<>();
    ArrayList<SubjectStudent> subjectStudentArrayList = new ArrayList<>();

    public void runView() {
        ConstructionManager constructionManager = ConstructionManager.getInstance();
        try {
            constructionManager.setConstructionStudentArrayList(ConstructionReadWriteFile.getInstance().readFile());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        int choice = -2;

        while (choice != 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập mã sinh viên: ");
            String codeStudent = scanner.nextLine();
            constructionStudent = constructionManager.searchStudent(codeStudent);
            System.out.println(constructionStudent);
            System.out.println("-----Sinh viên khoa công trình-----");
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
                    for (Subject sub: subjectList) {
                        total += sub.getTuition();
                    }
                    System.out.println("Học phí của học viên là:" + total);
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
            System.out.println("2. Đăng ký bộ môn thủy công");
            System.out.println("3. Đăng ký bộ môn toán");
            System.out.println("4. Đăng ký bộ môn cơ học");
            System.out.println("0. Quay lại");

            Scanner scanner = new Scanner(System.in);
            choose = scanner.nextInt();

            switch (choose) {
                case 1: {
                    System.out.println("1. Đăng ký bộ môn tiếng anh");
                    creatEng();
                }
                case 2: {
                    System.out.println("2. Đăng ký bộ môn thủy công");
                    creatHydr();
                }
                case 3: {
                    System.out.println("3. Đăng ký bộ môn toán");
                    creatMath();
                }
                case 4: {
                    System.out.println("4. Danh sách bộ môn cơ học");
                    creatMech();
                }
                case 0:
            }
        }
    }

    private void creatMech() {
        mechanics.runMechanics();
        Scanner scanner4 = new Scanner(System.in);
        System.out.println("Nhập mã môn học: ");
        String codeSub3 = scanner4.nextLine();
        subjectList.add(mechanics.sub(codeSub3));
    }

    private void creatMath() {
        math.runMath();
        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Nhập mã môn học: ");
        String codeSub2 = scanner3.nextLine();
        subjectList.add(math.sub(codeSub2));
    }

    private void creatHydr() {
        hydraulic.runHydraulic();
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Nhập mã môn học: ");
        String codeSub1 = scanner2.nextLine();
        subjectList.add(hydraulic.sub(codeSub1));
    }

    private void creatEng() {
        english.runEnglish();
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Nhập mã môn học: ");
        String codeSub = scanner1.nextLine();
        subjectList.add(english.sub(codeSub));
    }

    public SubjectStudent searchSubjectStudentMath(String nameTeacher) {
        SubjectStudent subjectStudent = new SubjectStudent(math.subNew(nameTeacher),constructionStudent);
        return subjectStudent;
    }

    public SubjectStudent searchSubjectStudentEnglish(String nameTeacher) {
        SubjectStudent subjectStudent = new SubjectStudent(english.subNew(nameTeacher),constructionStudent);
        return subjectStudent;
    }

    public SubjectStudent searchSubjectStudentHydraulic(String nameTeacher) {
        SubjectStudent subjectStudent = new SubjectStudent(hydraulic.subNew(nameTeacher),constructionStudent);
        subjectStudentManager.addNewSubjectStudent(subjectStudent);
        return subjectStudent;
    }

    public SubjectStudent searchSubjectStudentMechanics(String nameTeacher) {
        SubjectStudent subjectStudent = new SubjectStudent(mechanics.subNew(nameTeacher),constructionStudent);
        subjectStudentManager.addNewSubjectStudent(subjectStudent);
        return subjectStudent;
    }
}









package view.main.student;


import java.util.Scanner;

public class StudentMenuAll {
    private static final StudentMenuAll studentMenuAll = new StudentMenuAll();
    private StudentMenuAll() {
    }

    public static StudentMenuAll getInstance() {
        return studentMenuAll;
    }
   private static final AccountantStudentSub accountantStudentSub = new AccountantStudentSub();
   private static final AdministrationStudentSub administrationStudentSub = new AdministrationStudentSub();
   private static final ConstructionStudentSub constructionStudentSub = new ConstructionStudentSub();

   public void runAll() {
       Scanner scanner = new Scanner(System.in);
       int choice = -2;

       while (choice != 0) {
           System.out.println("Đăng ký học và tính tiền cho sinh viên");
           System.out.println("1. Sinh viên ngành kế toán");
           System.out.println("2. Sinh viên ngành quản lý");
           System.out.println("3. Sinh viên ngành công trình");
           System.out.println("0. Quay lại");

           choice = scanner.nextInt();

           switch (choice) {
               case 1: {
                   System.out.println("1. Sinh viên ngành kế toán");
                   accountantStudentSub.runView();
                   break;
               }
               case 2: {
                   System.out.println("2. Sinh viên ngành quản lý");
                   administrationStudentSub.runView();
                   break;
               }
               case 3: {
                   System.out.println("3. Sinh viên ngành công trình");
                   constructionStudentSub.runView();
                   break;
               }
               case 0:
           }
       }
   }
}

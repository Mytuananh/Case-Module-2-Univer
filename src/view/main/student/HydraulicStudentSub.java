package view.main.student;


import model.subject.Subject;
import view.subjectview.AllSubjectView;

import java.util.ArrayList;

public class HydraulicStudentSub {
    private static final AllSubjectView allSubjectView = new AllSubjectView();
    ArrayList<Subject> subjectList = new ArrayList<>();
   public void runView() {

       int choice = -2;

       while (choice != -1) {
           System.out.println("1. Đăng ký học");
           System.out.println("2. Xem học phí");
           System.out.println("0. Quay lại");
       }
   }
    }










package cotroller.management;

import cotroller.studentmanager.*;
import model.stduents.Freshman;

import java.util.ArrayList;

public class ManagementStudent {

    private FreshmanManager freshmanManager;
    private SophomoreManager sophomoreManager;
    private ThirdYearStudentManager thirdYearStudentManager;
    private FourthYearStudentManager fourthYearStudentManager;
    private FinalYearStudentManager finalYearStudentManager;

    public ManagementStudent() {
    }

    public ManagementStudent(FreshmanManager freshmanManager, SophomoreManager sophomoreManager, ThirdYearStudentManager thirdYearStudentManager, FourthYearStudentManager fourthYearStudentManager, FinalYearStudentManager finalYearStudentManager) {
        this.freshmanManager = freshmanManager;
        this.sophomoreManager = sophomoreManager;
        this.thirdYearStudentManager = thirdYearStudentManager;
        this.fourthYearStudentManager = fourthYearStudentManager;
        this.finalYearStudentManager = finalYearStudentManager;
    }

    public FreshmanManager getFreshmanManager() {
        return freshmanManager;
    }

    public void setFreshmanManager(FreshmanManager freshmanManager) {
        this.freshmanManager = freshmanManager;
    }

    public SophomoreManager getSophomoreManager() {
        return sophomoreManager;
    }

    public void setSophomoreManager(SophomoreManager sophomoreManager) {
        this.sophomoreManager = sophomoreManager;
    }

    public ThirdYearStudentManager getThirdYearStudentManager() {
        return thirdYearStudentManager;
    }

    public void setThirdYearStudentManager(ThirdYearStudentManager thirdYearStudentManager) {
        this.thirdYearStudentManager = thirdYearStudentManager;
    }

    public FourthYearStudentManager getFourthYearStudentManager() {
        return fourthYearStudentManager;
    }

    public void setFourthYearStudentManager(FourthYearStudentManager fourthYearStudentManager) {
        this.fourthYearStudentManager = fourthYearStudentManager;
    }

    public FinalYearStudentManager getFinalYearStudentManager() {
        return finalYearStudentManager;
    }

    public void setFinalYearStudentManager(FinalYearStudentManager finalYearStudentManager) {
        this.finalYearStudentManager = finalYearStudentManager;
    }


}

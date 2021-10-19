package cotroller.management;

import cotroller.teachermanager.EnglishTeacherManager;
import cotroller.teachermanager.HydraulicTeacherManager;
import cotroller.teachermanager.MathTeacherManager;
import cotroller.teachermanager.MechanicsTeacherManager;

public class ManagementTeacher {
    private EnglishTeacherManager englishTeacherManager;
    private HydraulicTeacherManager hydraulicTeacherManager;
    private MathTeacherManager mathTeacherManager;
    private MechanicsTeacherManager mechanicsTeacherManager;

    public ManagementTeacher() {
    }

    public ManagementTeacher(EnglishTeacherManager englishTeacherManager, HydraulicTeacherManager hydraulicTeacherManager, MathTeacherManager mathTeacherManager, MechanicsTeacherManager mechanicsTeacherManager) {
        this.englishTeacherManager = englishTeacherManager;
        this.hydraulicTeacherManager = hydraulicTeacherManager;
        this.mathTeacherManager = mathTeacherManager;
        this.mechanicsTeacherManager = mechanicsTeacherManager;
    }

    public EnglishTeacherManager getEnglishTeacherManager() {
        return englishTeacherManager;
    }

    public void setEnglishTeacherManager(EnglishTeacherManager englishTeacherManager) {
        this.englishTeacherManager = englishTeacherManager;
    }

    public HydraulicTeacherManager getHydraulicTeacherManager() {
        return hydraulicTeacherManager;
    }

    public void setHydraulicTeacherManager(HydraulicTeacherManager hydraulicTeacherManager) {
        this.hydraulicTeacherManager = hydraulicTeacherManager;
    }

    public MathTeacherManager getMathTeacherManager() {
        return mathTeacherManager;
    }

    public void setMathTeacherManager(MathTeacherManager mathTeacherManager) {
        this.mathTeacherManager = mathTeacherManager;
    }

    public MechanicsTeacherManager getMechanicsTeacherManager() {
        return mechanicsTeacherManager;
    }

    public void setMechanicsTeacherManager(MechanicsTeacherManager mechanicsTeacherManager) {
        this.mechanicsTeacherManager = mechanicsTeacherManager;
    }
}

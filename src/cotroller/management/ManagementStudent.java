package cotroller.management;

import cotroller.studentmanager.*;

public class ManagementStudent {

    private ConstructionManager constructionManager;
    private AccountantManager accountantManager;
    private AdministrationManager administrationManager;

    public ManagementStudent() {
    }

    public ManagementStudent(ConstructionManager constructionManager, AccountantManager accountantManager, AdministrationManager administrationManager) {
        this.constructionManager = constructionManager;
        this.accountantManager = accountantManager;
        this.administrationManager = administrationManager;

    }

    public ConstructionManager getFreshmanManager() {
        return constructionManager;
    }

    public void setFreshmanManager(ConstructionManager constructionManager) {
        this.constructionManager = constructionManager;
    }

    public AccountantManager getSophomoreManager() {
        return accountantManager;
    }

    public void setSophomoreManager(AccountantManager accountantManager) {
        this.accountantManager = accountantManager;
    }

    public AdministrationManager getThirdYearStudentManager() {
        return administrationManager;
    }

    public void setThirdYearStudentManager(AdministrationManager administrationManager) {
        this.administrationManager = administrationManager;
    }



}

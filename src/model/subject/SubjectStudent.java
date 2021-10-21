package model.subject;

import model.students.AccountantStudent;
import model.students.AdministrationStudent;
import model.students.ConstructionStudent;

import java.io.Serializable;

public class SubjectStudent implements Serializable {
    private Subject subject;
    private AccountantStudent accountantStudent;
    private AdministrationStudent administrationStudent;
    private ConstructionStudent constructionStudent;

    public SubjectStudent() {
    }

    public SubjectStudent(Subject subject, AccountantStudent accountantStudent) {
        this.subject = subject;
        this.accountantStudent = accountantStudent;
    }

    public SubjectStudent(Subject subject, AdministrationStudent administrationStudent) {
        this.subject = subject;
        this.administrationStudent = administrationStudent;
    }

    public SubjectStudent(Subject subject, ConstructionStudent constructionStudent) {
        this.subject = subject;
        this.constructionStudent = constructionStudent;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public AccountantStudent getAccountantStudent() {
        return accountantStudent;
    }

    public void setAccountantStudent(AccountantStudent accountantStudent) {
        this.accountantStudent = accountantStudent;
    }

    public AdministrationStudent getAdministrationStudent() {
        return administrationStudent;
    }

    public void setAdministrationStudent(AdministrationStudent administrationStudent) {
        this.administrationStudent = administrationStudent;
    }

    public ConstructionStudent getConstructionStudent() {
        return constructionStudent;
    }

    public void setConstructionStudent(ConstructionStudent constructionStudent) {
        this.constructionStudent = constructionStudent;
    }
}

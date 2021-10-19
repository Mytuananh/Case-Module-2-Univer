package model.students;

import java.io.Serializable;

public class AccountantStudent extends GeneralInformationStudent implements Serializable {
    private String name;
    private String dateOfBirth;
    private String codeStudent;
    private String className;
    private String homeTown;

    public AccountantStudent() {
    }

    public AccountantStudent(String name, String dateOfBirth, String codeStudent, String className, String homeTown) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.codeStudent = codeStudent;
        this.className = className;
        this.homeTown = homeTown;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCodeStudent() {
        return codeStudent;
    }

    public void setCodeStudent(String codeStudent) {
        this.codeStudent = codeStudent;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    @Override
    public String toString() {
        return "AccountantStudent{" +
                "name = '" + name + '\'' +
                ", dateOfBirth = '" + dateOfBirth + '\'' +
                ", codeStudent = '" + codeStudent + '\'' +
                ", className = '" + className + '\'' +
                ", homeTown = '" + homeTown + '\'' +
                '}';
    }
}

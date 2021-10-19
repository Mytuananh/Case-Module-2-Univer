package model.teachers;

import java.io.Serializable;

public class EnglishTeacher extends GeneralInformationTeacher implements Serializable {
    private String name;
    private String dateOfBirth;
    private String codeTeacher;
    private String homeTown;

    public EnglishTeacher() {
    }

    public EnglishTeacher(String name, String dateOfBirth, String codeTeacher, String homeTown) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.codeTeacher = codeTeacher;
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

    public String getCodeTeacher() {
        return codeTeacher;
    }

    public void setCodeTeacher(String codeTeacher) {
        this.codeTeacher = codeTeacher;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    @Override
    public String toString() {
        return "EnglishTeacher{" +
                "name = '" + name + '\'' +
                ", dateOfBirth = '" + dateOfBirth + '\'' +
                ", codeTeacher = '" + codeTeacher + '\'' +
                ", homeTown = '" + homeTown + '\'' +
                '}';
    }
}

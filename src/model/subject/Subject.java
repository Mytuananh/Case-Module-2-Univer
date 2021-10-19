package model.subject;

import java.io.Serializable;

public class Subject implements Serializable {
    private String codeSubject;
    private String name;
    private double tuition;
    private String nameTeacher;

    public Subject() {
    }

    public Subject(String name, double tuition, String nameTeacher, String codeSubject) {
        this.name = name;
        this.tuition = tuition;
        this.nameTeacher = nameTeacher;
        this.codeSubject = codeSubject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTuition() {
        return tuition;
    }

    public void setTuition(double tuition) {
        this.tuition = tuition;
    }

    public String getNameTeacher() {
        return nameTeacher;
    }

    public void setNameTeacher(String nameTeacher) {
        this.nameTeacher = nameTeacher;
    }

    public String getCodeSubject() {
        return codeSubject;
    }

    public void setCodeSubject(String codeSubject) {
        this.codeSubject = codeSubject;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "codeSubject='" + codeSubject + '\'' +
                ", name='" + name + '\'' +
                ", tuition=" + tuition +
                ", nameTeacher='" + nameTeacher + '\'' +
                '}';
    }
}
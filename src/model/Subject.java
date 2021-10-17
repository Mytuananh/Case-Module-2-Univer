package model;

public class Subject {
    private String name;
    private double tuition;
    private String nameTeacher;

    public Subject() {
    }

    public Subject(String name, double tuition, String nameTeacher) {
        this.name = name;
        this.tuition = tuition;
        this.nameTeacher = nameTeacher;
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

    @Override
    public String toString() {
        return "Subject{" +
                "name = '" + name + '\'' +
                ", tuition = " + tuition +
                ", nameTeacher = '" + nameTeacher + '\'' +
                '}';
    }
}

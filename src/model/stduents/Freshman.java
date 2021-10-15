package model.stduents;

public class Freshman {
    private String name;
    private String dateOfBirth;
    private String codeStudent;
    private String className;
    private String homeTown;
    private double collegeTestScores;

    public Freshman() {
    }

    public Freshman(String name, String dateOfBirth, String codeStudent, String className, String homeTown) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.codeStudent = codeStudent;
        this.className = className;
        this.homeTown = homeTown;
    }

    public Freshman(String name, String dateOfBirth, String codeStudent, String className, String homeTown, double collegeTestScores) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.codeStudent = codeStudent;
        this.className = className;
        this.homeTown = homeTown;
        this.collegeTestScores = collegeTestScores;
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

    public double getCollegeTestScores() {
        return collegeTestScores;
    }

    public void setCollegeTestScores(double collegeTestScores) {
        this.collegeTestScores = collegeTestScores;
    }

    @Override
    public String toString() {
        return "Freshman{" +
                "fullName = '" + name + '\'' +
                ", dateOfBirth = '" + dateOfBirth + '\'' +
                ", codeStudent = '" + codeStudent + '\'' +
                ", className = '" + className + '\'' +
                ", homeTown = '" + homeTown + '\'' +
                ", collegeTestScores = " + collegeTestScores +
                '}';
    }
}

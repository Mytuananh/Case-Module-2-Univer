package model.stduents;

public class FinalYearStudent {
    private String name;
    private String dateOfBirth;
    private String codeStudent;
    private String className;
    private String homeTown;
    private double finalGrade;

    public FinalYearStudent() {
    }

    public FinalYearStudent(String name, String dateOfBirth, String codeStudent, String className, String homeTown) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.codeStudent = codeStudent;
        this.className = className;
        this.homeTown = homeTown;
    }

    public FinalYearStudent(String name, String dateOfBirth, String codeStudent, String className, String homeTown, double finalGrade) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.codeStudent = codeStudent;
        this.className = className;
        this.homeTown = homeTown;
        this.finalGrade = finalGrade;
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

    public double getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(double finalGrade) {
        this.finalGrade = finalGrade;
    }

    @Override
    public String toString() {
        return "FinalYearStudent{" +
                "name='" + name + '\'' +
                ", dateOfBirth = '" + dateOfBirth + '\'' +
                ", codeStudent = '" + codeStudent + '\'' +
                ", className = '" + className + '\'' +
                ", homeTown = '" + homeTown + '\'' +
                ", finalGrade = " + finalGrade +
                '}';
    }
}

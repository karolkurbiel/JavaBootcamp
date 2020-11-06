package itacademy._10.personandstudent;

import java.time.LocalDate;

public class Student extends Person {
    private String faculty;
    private int graduateYear;

    public Student(String firstName, String lastName, LocalDate birthDate, String faculty, int graduateYear) {
        super(firstName, lastName, birthDate);
        this.faculty = faculty;
        this.graduateYear = graduateYear;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getGraduateYear() {
        return graduateYear;
    }

    public void setGraduateYear(int graduateYear) {
        this.graduateYear = graduateYear;
    }
}

package pl.edu.pg.dean.office.data.person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Teacher extends Person {

    private TeacherDegree degree = TeacherDegree.LACK;

    private static final String TEACHER_FILE = "teachers.txt";

    public Teacher(String first_name, String last_name, Long pesel) {
        super(first_name, last_name, pesel);
    }

    public TeacherDegree getDegree() {
        return degree;
    }

    public void setDegree(TeacherDegree degree) {
        this.degree = degree;
    }

    @Override
    public void info() {
        System.out.println(toString());
    }

    @Override
    public String getFileName() {
        return TEACHER_FILE;
    }

    @Override
    public List<String> getDataToSave() {
        List<String> data = new ArrayList<>();
        return Arrays.asList(this.firstName, this.lastName, this.degree.name(), String.valueOf(pesel));
    }

    @Override

    public String toString() {
        String result = "Nauczyciel: " + System.lineSeparator();
        result += "imię: " + firstName + System.lineSeparator();
        result += "nazwisko: " + lastName + System.lineSeparator();
        result += "stopień naukowy: " + degree.getLabel() + System.lineSeparator();
        result += "pesel: " + pesel + System.lineSeparator();
        return result;

    }
}

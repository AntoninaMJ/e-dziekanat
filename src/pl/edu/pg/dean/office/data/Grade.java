package pl.edu.pg.dean.office.data;

import pl.edu.pg.dean.office.data.person.Student;
import pl.edu.pg.dean.office.data.person.Teacher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Grade implements Saveable {

    public static final String GRADE_FILE = "grades.txt";

    private float value;
    private GradeType type;
    private Student student;
    private Teacher teacher;
    private Subject subject;

    public Grade(float value, Student student, Teacher teacher, Subject subject) {
        this.value = value;
        this.type = GradeType.fromValue(value);
        this.student = student;
        this.teacher = teacher;
        this.subject = subject;
    }

    public void info() {
        System.out.println(toString());
    }

    @Override
    public String getFileName() {
        return GRADE_FILE;
    }

    @Override
    public List<String> getDataToSave() {
        List<String> data = new ArrayList<>();
        return Arrays.asList(String.valueOf(value),
                String.valueOf(this.student.getPesel()),
                String.valueOf(this.teacher.getPesel()),
                this.subject.getName());
    }

    public String toString() {
        return "[Ocena: " + value + ", " + type.getFullName() + ", " + type.getName() + System.lineSeparator()
                + "Wystawiona dla studenta: " + student.getPesel() + System.lineSeparator() + "Nauczyciel: "
                + teacher.getPesel() + System.lineSeparator() + "Przedmiot: " + subject.getName() + "]";
    }

    public float getValue() {
        return value;
    }

    public GradeType getType() {
        return type;
    }

    public Student getStudent() {
        return student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Subject getSubject() {
        return subject;
    }
}
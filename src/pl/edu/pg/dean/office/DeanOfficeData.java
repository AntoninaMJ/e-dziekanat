package pl.edu.pg.dean.office;

import pl.edu.pg.dean.office.data.Grade;
import pl.edu.pg.dean.office.data.person.Student;
import pl.edu.pg.dean.office.data.Subject;
import pl.edu.pg.dean.office.data.person.Teacher;
import pl.edu.pg.dean.office.writer.Writer;

import java.io.IOException;
import java.util.List;

import static pl.edu.pg.dean.office.reader.GradesReader.readGrades;
import static pl.edu.pg.dean.office.reader.StudentsReader.readStudents;
import static pl.edu.pg.dean.office.reader.SubjectsReader.readSubjects;
import static pl.edu.pg.dean.office.reader.TeachersReader.readTeachers;

public class DeanOfficeData {

    private List<Student> students;
    private List<Teacher> teachers;
    private List<Subject> subjects;
    private List<Grade> grades;

    private Writer writer = new Writer();

    public void loadData() throws IOException {
        students = readStudents();
        teachers = readTeachers();
        subjects = readSubjects();
        grades = readGrades(this);

    }

    public void saveData() throws IOException {
        writer.saveAll(students);
        writer.saveAll(teachers);
        writer.saveAll(subjects);
        writer.saveAll(grades);

        writer.closeWriters();
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public List<Grade> getGrades() {
        return grades;
    }

}
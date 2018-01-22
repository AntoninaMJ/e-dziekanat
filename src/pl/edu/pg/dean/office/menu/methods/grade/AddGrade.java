package pl.edu.pg.dean.office.menu.methods.grade;

import pl.edu.pg.dean.office.data.Subject;
import pl.edu.pg.dean.office.DeanOfficeData;
import pl.edu.pg.dean.office.data.Grade;
import pl.edu.pg.dean.office.data.person.Student;
import pl.edu.pg.dean.office.data.person.Teacher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static pl.edu.pg.dean.office.util.Searcher.searchPerson;
import static pl.edu.pg.dean.office.util.Searcher.searchSubject;

public class AddGrade {

    public static void addGrade(DeanOfficeData data) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Wprowadź ocenę: ");
            Float grade = Float.valueOf(br.readLine());
            System.out.println("Wprowadź pesel studenta: ");
            Long peselStudent = Long.valueOf(br.readLine());
            System.out.println("Wprowadź pesel nauczyciela: ");
            Long peselTeacher = Long.valueOf(br.readLine());
            System.out.println("Wprowadź nazwę przedmiotu: ");
            String nameSubject = br.readLine();

            Student student = searchPerson(peselStudent, data.getStudents());
            Teacher teacher = searchPerson(peselTeacher, data.getTeachers());
            Subject subject = searchSubject(nameSubject, data.getSubjects());

            if (student != null && teacher != null && subject != null) {
                Grade gradeToAdd = new Grade(grade, student, teacher, subject);
                data.getGrades().add(gradeToAdd);
                System.out.println(System.lineSeparator() + "Ocena pomyślnie dodana" + System.lineSeparator());
                System.out.println(gradeToAdd);
            } else {
                System.out.println("Złe dane, taki student, albo nauczyciel, albo przedmiot nie istnieje.");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package pl.edu.pg.dean.office.menu.methods;

import pl.edu.pg.dean.office.data.Subject;
import pl.edu.pg.dean.office.DeanOfficeData;
import pl.edu.pg.dean.office.menu.Menu;
import pl.edu.pg.dean.office.menu.MenuItem;
import pl.edu.pg.dean.office.data.person.Student;
import pl.edu.pg.dean.office.data.person.Teacher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static pl.edu.pg.dean.office.util.Searcher.searchPerson;
import static pl.edu.pg.dean.office.util.Searcher.searchSubject;

public class Delete {

    public static void delete(DeanOfficeData data, MenuItem menuItem) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            switch (menuItem) {
                case STUDENTS:
                    System.out.println("Wprowadź pesel studenta do usunięcia: ");
                    Long peselStudent = Long.valueOf(br.readLine());
                    System.out.println();
                    Student studentToRemove = searchPerson(peselStudent, data.getStudents());
                    if (studentToRemove == null) {
                        System.out.println("Student o takim peselu nie isnieje. Spróbuj jeszcze raz\n");
                    } else {
                        System.out.println(studentToRemove);
                        data.getStudents().remove(studentToRemove);
                        System.out.println("Student pomyślnie usunięty.");
                    }
                    break;
                case TEACHERS:
                    System.out.println("Wprowadź pesel nauczyciela do usunięcia: ");
                    Long peselTeacher = Long.valueOf(br.readLine());
                    System.out.println();
                    Teacher teacherToRemove = searchPerson(peselTeacher, data.getTeachers());
                    if (teacherToRemove == null) {
                        System.out.println("Nauczyciel o takim peselu nie isnieje. Spróbuj jeszcze raz.\n");
                    } else {
                        System.out.println(teacherToRemove);
                        data.getTeachers().remove(teacherToRemove);
                        System.out.println("Nauczyciel pomyślnie usunięty.");
                    }
                    break;
                case SUBJECTS:
                    System.out.println("Wprowadź nazwę przedmiotu do usunięcia: ");
                    String name = br.readLine();
                    System.out.println();
                    Subject subjectToRemove = searchSubject(name, data.getSubjects());
                    if (subjectToRemove == null) {
                        System.out.println("Przedmiot o takiej nazwie nie isnieje. Spróbuj jeszcze raz.\n");
                    } else {
                        System.out.println(subjectToRemove);
                        data.getSubjects().remove(subjectToRemove);
                        System.out.println("Przedmiot pomyślnie usunięty.");
                    }
                    break;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

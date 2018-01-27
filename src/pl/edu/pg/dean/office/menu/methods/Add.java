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

public class Add {

    public static void add(DeanOfficeData data, MenuItem menuItem) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            switch (menuItem) {
                case STUDENTS:
                    System.out.println("Wprowadź pesel studenta: ");
                    Long peselStudent = Long.valueOf(br.readLine());
                    if (searchPerson(peselStudent, data.getStudents()) == null) {
                        System.out.println("Wprowadź imię studenta: ");
                        String name = br.readLine();
                        System.out.println("Wprowadź nazwisko studenta: ");
                        String lastName = br.readLine();
                        System.out.println("Wprowadź numer albumu studenta: ");
                        String albumNumber = br.readLine();
                        Student studentToAdd = new Student(name, lastName, peselStudent, albumNumber);
                        data.getStudents().add(studentToAdd);
                        System.out.println("\nStudent pomyślnie dodany.\n");
                        System.out.println(studentToAdd);
                    } else {
                        System.out.println("\nStudent o takim peselu już istnieje. Spróbuj jeszcze raz.\n");
                    }
                    break;
                case TEACHERS:
                    System.out.println("Wprowadź pesel nauczyciela: ");
                    Long peselTeacher = Long.valueOf(br.readLine());
                    if (searchPerson(peselTeacher, data.getTeachers()) == null) {
                        System.out.println("Wprowadź imię nauczyciela: ");
                        String name = br.readLine();
                        System.out.println("Wprowadź nazwisko nauczyciela: ");
                        String lastName = br.readLine();
                        Teacher teacherToAdd = new Teacher(name, lastName, peselTeacher);
                        data.getTeachers().add(teacherToAdd);
                        System.out.println("\nNauczyciel pomyślnie dodany.\n");
                        System.out.println(teacherToAdd);
                    } else {
                        System.out.println("\nNauczyciel o takim peselu już isnieje. Spróbuj jeszcze raz.\n");
                    }
                    break;
                case SUBJECTS:
                    System.out.println("Wprowadź nazwę przediotu: ");
                    String name = br.readLine();
                    if (searchSubject(name, data.getSubjects()) == null) {
                        System.out.println("Wprowadź punkty ECTS: ");
                        Integer ECTS_points = Integer.valueOf(br.readLine());
                        Subject subjectToAdd = new Subject(name, ECTS_points);
                        data.getSubjects().add(subjectToAdd);
                        System.out.println("\nPrzedmiot pomyślnie dodany.\n");
                        System.out.println(subjectToAdd);
                    } else {
                        System.out.println("\nPrzedniot o takiej nazwie już istnieje. Spróbuj jeszcze raz.\n");
                    }
                    break;
                case STATISTICS:
                    System.out.println("\nNie dostępne dla statystyk. Spróbuj wyświetlić statystyki\n");
                    break;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

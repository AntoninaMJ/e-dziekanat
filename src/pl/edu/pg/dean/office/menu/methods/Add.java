package pl.edu.pg.dean.office.menu.methods;

import pl.edu.pg.dean.office.data.Subject;
import pl.edu.pg.dean.office.DeanOfficeData;
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
            if (menuItem == MenuItem.STUDENTS) {
                System.out.println("Wprowadź pesel studenta: ");
                Long pesel = Long.valueOf(br.readLine());
                if (searchPerson(pesel, data.getStudents()) == null) {
                    System.out.println("Wprowadź imię studenta: ");
                    String name = br.readLine();
                    System.out.println("Wprowadź nazwisko studenta: ");
                    String lastName = br.readLine();
                    System.out.println("Wprowadź numer albumu studenta: ");
                    String albumNumber = br.readLine();
                    Student studentToAdd = new Student(name, lastName, pesel, albumNumber);
                    data.getStudents().add(studentToAdd);
                    System.out.println(System.lineSeparator() + "Student pomyślnie dodany." + System.lineSeparator());
                    System.out.println(studentToAdd);
                } else {
                    System.out.println(System.lineSeparator() + "Student o takim peselu już istnieje.");
                }

            } else if (menuItem == MenuItem.TEACHERS) {
                System.out.println("Wprowadź pesel nauczyciela: ");
                Long pesel = Long.valueOf(br.readLine());
                if (searchPerson(pesel, data.getTeachers()) == null) {
                    System.out.println("Wprowadź imię nauczyciela: ");
                    String name = br.readLine();
                    System.out.println("Wprowadź nazwisko nauczyciela: ");
                    String lastName = br.readLine();
                    Teacher teacherToAdd = new Teacher(name, lastName, pesel);
                    data.getTeachers().add(teacherToAdd);
                    System.out.println(System.lineSeparator() + "Nauczyciel pomyślnie dodany." + System.lineSeparator());
                    System.out.println(teacherToAdd);
                } else {
                    System.out.println(System.lineSeparator() + "Nauczyciel o takim peselu już isnieje.");
                }
            } else if (menuItem == MenuItem.SUBJECTS) {
                System.out.println("Wprowadź nazwę przediotu: ");
                String name = br.readLine();
                if (searchSubject(name, data.getSubjects()) == null) {
                    System.out.println("Wprowadź punkty ECTS: ");
                    Integer ECTS_points = Integer.valueOf(br.readLine());
                    Subject subjectToAdd = new Subject(name, ECTS_points);
                    data.getSubjects().add(subjectToAdd);
                    System.out.println(System.lineSeparator() + "Przedmiot pomyślnie dodany." + System.lineSeparator());
                    System.out.println(subjectToAdd);
                } else {
                    System.out.println(System.lineSeparator() + "Przedniot o takiej nazwie już istnieje.");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

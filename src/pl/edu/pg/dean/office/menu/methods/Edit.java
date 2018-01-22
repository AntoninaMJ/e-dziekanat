package pl.edu.pg.dean.office.menu.methods;

import pl.edu.pg.dean.office.DeanOfficeData;
import pl.edu.pg.dean.office.data.person.TeacherDegree;
import pl.edu.pg.dean.office.menu.MenuItem;
import pl.edu.pg.dean.office.data.person.Student;
import pl.edu.pg.dean.office.data.person.StudentStatus;
import pl.edu.pg.dean.office.data.person.Teacher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static pl.edu.pg.dean.office.util.Searcher.searchPerson;

public class Edit {

    public static void edit(DeanOfficeData data, MenuItem menuItem) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            if (menuItem == MenuItem.STUDENTS) {
                System.out.println("Wprowadź pesel studenta do edycji");
                Long pesel = Long.valueOf(br.readLine());
                Student studentToEdit = searchPerson(pesel, data.getStudents());
                if (studentToEdit == null) {
                    System.out.println("Student o takim peselu nie istnieje.");
                } else {
                    System.out.println(System.lineSeparator() + studentToEdit);
                    System.out.println("Wybierz nowy status dla studenta: ");
                    for (StudentStatus studentStatus : StudentStatus.values()) {
                        System.out.format("%s. %s. %s", studentStatus.getOption(), studentStatus.getValueEN(), studentStatus.getValuePl());
                        System.out.println();
                    }
                    int inputStatus = Integer.parseInt(br.readLine());
                    System.out.println("Wybrałeś " + inputStatus + "\r\n");
                    StudentStatus status = StudentStatus.fromOption(inputStatus);
                    studentToEdit.setStatus(status);
                    System.out.println(studentToEdit);
                }

            } else if (menuItem == MenuItem.TEACHERS) {
                System.out.println("Wprowadź pesel nauczyciela do edycji stopnia naukowego: ");
                Long pesel = Long.valueOf(br.readLine());
                Teacher teacherToEdit = searchPerson(pesel, data.getTeachers());
                if (teacherToEdit == null) {
                    System.out.println("Nauczyciel o takim peselu nie istnieje.");
                } else {
                    System.out.println(System.lineSeparator() + teacherToEdit);
                    System.out.println("Wybierz nowy stopień naukowy dla nauczyciela:");
                    for (TeacherDegree teacherDegree : TeacherDegree.values()) {
                        System.out.format("%s. %s.", teacherDegree.getOption(), teacherDegree.getLabel());
                        System.out.println();
                    }
                    int inputDegree = Integer.parseInt(br.readLine());
                    System.out.println("Wybrałeś " + inputDegree + "\r\n");
                    TeacherDegree degree = TeacherDegree.fromOption(inputDegree);
                    teacherToEdit.setDegree(degree);
                    System.out.println(teacherToEdit);
                }

            } else if (menuItem == MenuItem.SUBJECTS) {
                System.out.println("Nie ma możliwości zmiany przedmiotu, wprowadź nowy przedmiot.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

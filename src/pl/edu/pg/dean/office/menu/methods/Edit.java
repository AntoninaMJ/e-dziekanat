package pl.edu.pg.dean.office.menu.methods;

import pl.edu.pg.dean.office.DeanOfficeData;
import pl.edu.pg.dean.office.data.person.TeacherDegree;
import pl.edu.pg.dean.office.menu.Menu;
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

            switch (menuItem) {
                case STUDENTS:
                    System.out.println("Wprowadź pesel studenta do edycji");
                    Long peselStudent = Long.valueOf(br.readLine());
                    Student studentToEdit = searchPerson(peselStudent, data.getStudents());
                    if (studentToEdit == null) {
                        System.out.println("Student o takim peselu nie istnieje. Spróbuj jeszcze raz\n");
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
                    break;
                case TEACHERS:
                    System.out.println("Wprowadź pesel nauczyciela do edycji stopnia naukowego: ");
                    Long peselTeacher = Long.valueOf(br.readLine());
                    Teacher teacherToEdit = searchPerson(peselTeacher, data.getTeachers());
                    if (teacherToEdit == null) {
                        System.out.println("Nauczyciel o takim peselu nie istnieje. Spróbuj jeszcze raz\n");
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
                    break;
                case SUBJECTS:
                    System.out.println("Nie ma możliwości zmiany przedmiotu. Spróbuj dodać nowy.\n");
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

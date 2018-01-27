package pl.edu.pg.dean.office.menu.methods;

import org.omg.PortableInterceptor.ACTIVE;
import pl.edu.pg.dean.office.data.Grade;
import pl.edu.pg.dean.office.data.Subject;
import pl.edu.pg.dean.office.DeanOfficeData;
import pl.edu.pg.dean.office.data.person.StudentStatus;
import pl.edu.pg.dean.office.menu.MenuItem;
import pl.edu.pg.dean.office.data.person.Student;
import pl.edu.pg.dean.office.data.person.Teacher;

import java.util.OptionalDouble;

public class List {

    public static void list(DeanOfficeData data, MenuItem menuItem) {
        switch (menuItem) {
            case STUDENTS:
                for (Student student : data.getStudents()) {
                    System.out.println(student);
                }
                break;
            case TEACHERS:
                for (Teacher teacher : data.getTeachers()) {
                    System.out.println(teacher);
                }
                break;
            case SUBJECTS:
                for (Subject subject : data.getSubjects()) {
                    System.out.println(subject);
                }
                break;
            case STATISTICS:
                System.out.println("Liczba studentów: " + data.getStudents().size());
                System.out.println("\nLiczba nauczycieli: " + data.getTeachers().size());
                System.out.println("\nLiczba przedmiotów: " + data.getSubjects().size());
                System.out.println("\nLiczba wystawionych ocen: " + data.getGrades().size());

                int counter = 0;
                for (Student student : data.getStudents()) {
                    if (student.getStatus().equals(StudentStatus.ACTIVE)) {
                        counter++;
                    }
                }
                System.out.println("\nLiczba Aktywnych studentów: " + counter + System.lineSeparator());
                break;
        }
    }
}

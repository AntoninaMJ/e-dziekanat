package pl.edu.pg.dean.office.menu.methods;

import pl.edu.pg.dean.office.data.Subject;
import pl.edu.pg.dean.office.DeanOfficeData;
import pl.edu.pg.dean.office.menu.MenuItem;
import pl.edu.pg.dean.office.data.person.Student;
import pl.edu.pg.dean.office.data.person.Teacher;

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
        }
    }
}

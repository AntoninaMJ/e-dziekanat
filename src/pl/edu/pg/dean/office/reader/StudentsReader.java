package pl.edu.pg.dean.office.reader;

import pl.edu.pg.dean.office.data.person.Student;
import pl.edu.pg.dean.office.data.person.StudentStatus;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentsReader {

    public static List<Student> readStudents() throws IOException {
        File file = new File("students.txt");
        List<Student> students = new ArrayList<>();

        try {
            Scanner sc = new Scanner(file);
            List<String> listOfLines = new ArrayList<>();
            while (sc.hasNextLine()) {
                String i = sc.nextLine();
                listOfLines.add(i);
                if (listOfLines.size() == 6) {
                    Student student = new Student(listOfLines.get(1), listOfLines.get(2), Long.valueOf(listOfLines.get(3)), listOfLines.get(4));
                    student.setStatus(StudentStatus.valueOf(listOfLines.get(5)));
                    students.add(student);
                    listOfLines.clear();
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return students;
    }
}

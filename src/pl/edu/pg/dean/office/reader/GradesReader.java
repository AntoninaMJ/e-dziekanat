package pl.edu.pg.dean.office.reader;

import pl.edu.pg.dean.office.DeanOfficeData;
import pl.edu.pg.dean.office.data.Grade;
import pl.edu.pg.dean.office.data.person.Student;
import pl.edu.pg.dean.office.data.person.Teacher;
import pl.edu.pg.dean.office.data.Subject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static pl.edu.pg.dean.office.util.Searcher.searchPerson;
import static pl.edu.pg.dean.office.util.Searcher.searchSubject;

public class GradesReader {

    public static List<Grade> readGrades(DeanOfficeData data) throws IOException {
        File file = new File("grades.txt");
        List<Grade> grades = new ArrayList<>();

        try {
            Scanner sc = new Scanner(file);
            List<String> listOfLines = new ArrayList<>();
            while (sc.hasNextLine()) {
                String i = sc.nextLine();
                listOfLines.add(i);
                if (listOfLines.size() == 4) {

                    Float grade = Float.valueOf(listOfLines.get(0));
                    Student student = searchPerson(Long.valueOf(listOfLines.get(1)), data.getStudents());
                    Teacher teacher = searchPerson(Long.valueOf(listOfLines.get(2)), data.getTeachers());
                    Subject subject = searchSubject(listOfLines.get(3), data.getSubjects());

                    if (student != null && teacher != null && subject != null) {
                        Grade gradeToAdd = new Grade(grade, student, teacher, subject);
                        grades.add(gradeToAdd);
                        listOfLines.clear();
                    } else {
                        System.out.println("coś poszło nie tak!");
                    }
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return grades;
    }
}
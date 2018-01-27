package pl.edu.pg.dean.office.menu.methods.grade;

import pl.edu.pg.dean.office.DeanOfficeData;
import pl.edu.pg.dean.office.data.Grade;
import pl.edu.pg.dean.office.data.Subject;
import pl.edu.pg.dean.office.data.person.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

import static pl.edu.pg.dean.office.util.Searcher.searchPerson;


public class AverageWeighted {
    public static void averageWeighted(DeanOfficeData data) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Wpisz pesel studenta: ");
            Long pesel = Long.valueOf(br.readLine());

            List<Student> students = data.getGrades().stream()
                    .map(Grade::getStudent)
                    .collect(Collectors.toList());
            Student student = searchPerson(pesel, students);

            float sumGradePerECTS = 0;
            float sumECTS = 0;
            if (student != null) {
                for (Grade grade : data.getGrades()) {
                    if (grade.getStudent().equals(student)) {
                        int ECTS = grade.getSubject().getECTS_points();
                        float value = grade.getValue();
                        sumGradePerECTS += ECTS * value;
                        sumECTS += ECTS;
                    }
                }
                System.out.println("\nStudent:\n" + student + "\nśrednia ważona: " + sumGradePerECTS / sumECTS);
            } else {
                System.out.println("\nBrak ocen tego studenta.\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

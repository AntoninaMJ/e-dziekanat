package pl.edu.pg.dean.office.menu.methods.grade;

import pl.edu.pg.dean.office.DeanOfficeData;
import pl.edu.pg.dean.office.data.Grade;
import pl.edu.pg.dean.office.data.person.Student;
import pl.edu.pg.dean.office.menu.Menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import static pl.edu.pg.dean.office.util.Searcher.searchPerson;

public class AverageGradeStudent {

    public static void averageGradeStudent(DeanOfficeData data) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Wpisz pesel studenta: ");
            Long pesel = Long.valueOf(br.readLine());

            List<Student> students = data.getGrades().stream()
                    .map(Grade::getStudent)
                    .collect(Collectors.toList());
            Student student = searchPerson(pesel, students);

            if (student != null) {
                OptionalDouble average = data.getGrades().stream()
                        .filter((grade) -> grade.getStudent().equals(student))
                        .peek((grade) -> System.out.println(grade + System.lineSeparator()))
                        .mapToDouble(Grade::getValue).average();

                if (average.isPresent()) {
                    System.out.println("Średnia ocena studenta: " + average.getAsDouble());
                }
            } else {
                System.out.println("\nStudent o takim peselu nie istnieje. Spróbuj jeszcze raz.\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

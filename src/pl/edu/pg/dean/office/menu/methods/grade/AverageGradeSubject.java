package pl.edu.pg.dean.office.menu.methods.grade;

import pl.edu.pg.dean.office.DeanOfficeData;
import pl.edu.pg.dean.office.data.Grade;
import pl.edu.pg.dean.office.data.Subject;
import pl.edu.pg.dean.office.data.person.Student;
import pl.edu.pg.dean.office.menu.Menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import static pl.edu.pg.dean.office.util.Searcher.searchPerson;
import static pl.edu.pg.dean.office.util.Searcher.searchSubject;

public class AverageGradeSubject {

    public static void averageGradeSubject(DeanOfficeData data) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Wpisz nazwę przedmiotu: ");
            String name = br.readLine();

            List<Subject> subjects = data.getGrades().stream()
                    .map(Grade::getSubject)
                    .collect(Collectors.toList());
            Subject subject = searchSubject(name, subjects);

            if (subject != null) {
                OptionalDouble average = data.getGrades().stream()
                        .filter((grade) -> grade.getSubject().equals(subject))
                        .peek((grade) -> System.out.println(grade + System.lineSeparator()))
                        .mapToDouble(Grade::getValue).average();
                if (average.isPresent()) {
                    System.out.println("Średnia ocena z przedmiotu: " + average.getAsDouble());
                }

            } else {
                System.out.println("\nPrzedmiot o takiej nazwie nie isnieje. Spróbuj jeszcze raz.\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package pl.edu.pg.dean.office.util;

import pl.edu.pg.dean.office.data.person.Person;
import pl.edu.pg.dean.office.data.Subject;

import java.util.List;

public class Searcher {

    public static <T extends Person> T searchPerson(Long pesel, List<T> people) {

        return people.stream()
                .filter((person) -> person.getPesel().equals(pesel))
                .findFirst()
                .orElse(null);
    }

    public static Subject searchSubject(String name, List<Subject> subjects) {

        return subjects.stream()
                .filter((subject) -> subject.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}

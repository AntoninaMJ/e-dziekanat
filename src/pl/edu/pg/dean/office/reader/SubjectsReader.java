package pl.edu.pg.dean.office.reader;

import pl.edu.pg.dean.office.data.Subject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubjectsReader {

    public static List<Subject> readSubjects() throws IOException {
        File file = new File("subjects.txt");
        List<Subject> subjects = new ArrayList<>();

        try {
            Scanner sc = new Scanner(file);
            List<String> listOfLines = new ArrayList<>();
            while (sc.hasNextLine()) {
                String i = sc.nextLine();
                listOfLines.add(i);
                if (listOfLines.size() == 2) {
                    Subject subject = new Subject(listOfLines.get(0), Integer.valueOf(listOfLines.get(1)));
                    subjects.add(subject);
                    listOfLines.clear();
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return subjects;
    }
}

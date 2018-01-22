package pl.edu.pg.dean.office.reader;

import pl.edu.pg.dean.office.data.person.Teacher;
import pl.edu.pg.dean.office.data.person.TeacherDegree;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeachersReader {

    public static List<Teacher> readTeachers() throws IOException {
        File file = new File("teachers.txt");
        List<Teacher> teachers = new ArrayList<>();

        try {
            Scanner sc = new Scanner(file);
            List<String> listOfLines = new ArrayList<>();
            while (sc.hasNextLine()) {
                String i = sc.nextLine();
                listOfLines.add(i);
                if (listOfLines.size() == 4) {
                    Teacher teacher = new Teacher(listOfLines.get(0), listOfLines.get(1), Long.valueOf(listOfLines.get(3)));
                    teacher.setDegree(TeacherDegree.valueOf(listOfLines.get(2)));
                    teachers.add(teacher);
                    listOfLines.clear();
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return teachers;
    }
}

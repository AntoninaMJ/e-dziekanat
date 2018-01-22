package pl.edu.pg.dean.office.menu.methods.grade;

import pl.edu.pg.dean.office.DeanOfficeData;
import pl.edu.pg.dean.office.data.Grade;

import java.io.IOException;

public class ListGrades {

    public static void listGrades(DeanOfficeData data) {
        for (Grade grade : data.getGrades()) {
            System.out.println(grade);
        }
    }
}

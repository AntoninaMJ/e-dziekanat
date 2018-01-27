package pl.edu.pg.dean.office.menu;

import pl.edu.pg.dean.office.DeanOfficeData;
import pl.edu.pg.dean.office.menu.methods.grade.*;

import java.util.Arrays;
import java.util.function.Consumer;

public enum SubMenuItemGrades {

    ADD_GRADE("Wystawić", AddGrade::addGrade),
    LIST_GRADES("Wyświetlić", ListGrades::listGrades),
    AVERAGE_SUBJECT("Wyświetlić średnią po przedmiotach", AverageGradeSubject::averageGradeSubject),
    AVERAGE_STUDENT("Wyświetlić średnią po studentach", AverageGradeStudent::averageGradeStudent),
    AVERAGE_WEIGHTED("Wyświetl średnią ważoną", AverageWeighted::averageWeighted),
    GO_BACK("Wyjście do głównego menu", (data) -> {
        System.out.println("Wyjście do głównego menu\n");
    });

    private String label;
    private Consumer<DeanOfficeData> method;

    SubMenuItemGrades(String label, Consumer<DeanOfficeData> method) {
        this.label = label;
        this.method = method;
    }

    public int getOption() {
        return ordinal() + 1;
    }

    public String getLabel() {
        return label;
    }

    public Consumer<DeanOfficeData> getMethod() {
        return method;
    }

    public static SubMenuItemGrades fromOption(int option) {

        return Arrays.stream(values())
                .filter((item) -> item.getOption() == option)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Wprowadziłeś złe dane, spróbuj jeszcze raz"));
    }

}

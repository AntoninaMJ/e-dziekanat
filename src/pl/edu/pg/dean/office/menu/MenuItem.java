package pl.edu.pg.dean.office.menu;

import java.util.Arrays;

public enum MenuItem {

    STUDENTS("Studenci"),
    TEACHERS("Nauczyciele"),
    SUBJECTS("Przedmioty"),
    GRADES("Oceny"),
    EXIT("Wyjście z programu");

    private String label;

    MenuItem(String label) {
        this.label = label;
    }

    public static MenuItem fromOption(int option) {

        return Arrays.stream(values())
                .filter((item) -> item.getOption() == option)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Wprowadziłeś złe dane, spróbuj jeszcze raz"));
    }

    public int getOption() {
        return ordinal() + 1;
    }

    public String getLabel() {
        return label;
    }
}
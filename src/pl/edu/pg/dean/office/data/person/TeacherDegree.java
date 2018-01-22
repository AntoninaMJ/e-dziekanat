package pl.edu.pg.dean.office.data.person;

import java.util.Arrays;

public enum TeacherDegree {
    LACK("Brak"),
    DOCTOR("Doktor"),
    DOCTOR_HAB("Doktor habilitowany");

    private String label;

    TeacherDegree(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public int getOption() {
        return ordinal() + 1;
    }

    public static TeacherDegree fromOption(int option) {
        return Arrays.stream(values())
                .filter((item) -> item.getOption() == option)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Wprowadziłeś złe dane, spróbuj jeszcze raz"));
    }

}

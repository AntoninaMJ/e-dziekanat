package pl.edu.pg.dean.office.data;

import java.util.Arrays;

public enum GradeType {

    A(5.0f, 6.0f, "bdb", "bardzo dobry"),
    B(4.0f, 5.0f, "db", "dobry"),
    C(3.0f, 4.0f, "dst", "dostateczny"),
    D(2.0f, 3.0f, "dop", "dopuszczający"),
    E(1.0f, 2.0f, "ndst", "nie dostateczny");

    private float minValue;
    private float maxValue;
    private String name;
    private String fullName;

    GradeType(float minValue, float maxValue, String name, String fullName) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.name = name;
        this.fullName = fullName;
    }

    public static GradeType fromValue(float value) {

        return Arrays.stream(values())
                .filter((gradeType) -> gradeType.minValue <= value && gradeType.maxValue > value)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Wprowadziłeś złe dane, spróbuj jeszcze raz"));
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }
}

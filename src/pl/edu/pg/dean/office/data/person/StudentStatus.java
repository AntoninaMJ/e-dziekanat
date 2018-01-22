package pl.edu.pg.dean.office.data.person;

import java.util.Arrays;

public enum StudentStatus {
    ACTIVE("Aktywny", "Active"),
    REMOVED("Skreślony", "Removed"),
    ON_BREAK("Urlopowany", "On break");

    private String valuePl;
    private String valueEN;

    StudentStatus(String valuePl, String valueEN) {
        this.valuePl = valuePl;
        this.valueEN = valueEN;
    }

    public static StudentStatus fromOption(int option) {

        return Arrays.stream(values())
                .filter((item) -> item.getOption() == option)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Wprowadziełeś złe dane, spróbuj jeszcze raz"));
    }

    public int getOption() {
        return ordinal() + 1;
    }

    public String getValuePl() {
        return valuePl;
    }

    public String getValueEN() {
        return valueEN;
    }

}

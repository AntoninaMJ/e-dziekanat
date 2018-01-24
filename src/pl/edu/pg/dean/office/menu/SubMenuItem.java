package pl.edu.pg.dean.office.menu;

import pl.edu.pg.dean.office.DeanOfficeData;
import pl.edu.pg.dean.office.menu.methods.Add;
import pl.edu.pg.dean.office.menu.methods.Delete;
import pl.edu.pg.dean.office.menu.methods.Edit;
import pl.edu.pg.dean.office.menu.methods.List;

import java.util.Arrays;
import java.util.function.BiConsumer;

public enum SubMenuItem {

    ADD("Dodać", Add::add),
    EDIT("Zmienić", Edit::edit),
    DELETE("Usunąć", Delete::delete),
    LIST("Wyświetlić", List::list),
    GO_BACK("Wyjście do głównego menu", (data, menuItem) -> {
        System.out.println("Wyjście do głównego menu\n");
    });

    private String label;
    private BiConsumer<DeanOfficeData, MenuItem> method;

    SubMenuItem(String label, BiConsumer<DeanOfficeData, MenuItem> method) {
        this.label = label;
        this.method = method;
    }

    public int getOption() {
        return ordinal() + 1;
    }

    public String getLabel() {
        return label;
    }

    public BiConsumer<DeanOfficeData, MenuItem> getMethod() {
        return method;
    }

    public static SubMenuItem fromOption(int option) {

        return Arrays.stream(values())
                .filter((item) -> item.getOption() == option)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Wprowadziłeś złe dane, spróbuj jeszcze raz"));
    }

}

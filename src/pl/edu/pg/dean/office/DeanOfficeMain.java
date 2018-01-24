package pl.edu.pg.dean.office;

import pl.edu.pg.dean.office.menu.Menu;

import java.io.IOException;

public class DeanOfficeMain {

    public static void main(String[] args) throws IOException {
        DeanOfficeData data = new DeanOfficeData();

        data.loadData();

        Menu menu = new Menu(data);

        boolean result;

        do {
            result = menu.communication();
        }
        while (!result);

        data.saveData();

        System.exit(0);
    }
}

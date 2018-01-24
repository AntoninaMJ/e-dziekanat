package pl.edu.pg.dean.office.menu;

import pl.edu.pg.dean.office.DeanOfficeData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {

    private DeanOfficeData data;
    private BufferedReader bufferedReader;

    public Menu(DeanOfficeData data) {
        this.data = data;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public boolean communication() {
        System.out.println("Witam, proszę wybrać opcję: ");

        for (MenuItem menuItem : MenuItem.values()) {
            System.out.format("%s. %s", menuItem.getOption(), menuItem.getLabel());
            System.out.println();
        }

        try {
            int inputMenu = Integer.parseInt(bufferedReader.readLine());
            if (inputMenu < 0 || inputMenu > 5) {
                System.out.println("Wprowadziłeś złe dane, spróbuj jeszcze raz\r\n");
            } else if (inputMenu == 5) {
                System.out.println("Wyszedłeś z programu\r\n");
                return true;
            } else {
                System.out.println("Wybrałeś " + inputMenu + "\r\n");
                MenuItem menuItem = MenuItem.fromOption(inputMenu);

                if (menuItem != MenuItem.GRADES) {
                    noGrades(menuItem);
                } else {
                    grades();
                }
            }
        } catch (IOException ioe) {
            System.out.println("IO error trying to read your input!\r\n");
        }

        return false;
    }

    private void noGrades(MenuItem menuItem) {
        System.out.println("Proszę wybrać sub menu dla wybranej opcji: ");

        for (SubMenuItem subMenuItem : SubMenuItem.values()) {
            System.out.format("%s. %s", subMenuItem.getOption(), subMenuItem.getLabel());
            System.out.println();
        }
        try {
            int inputSubMenu = Integer.parseInt(bufferedReader.readLine());
            System.out.println("Wybrałeś " + inputSubMenu + "\r\n");

            try {
                SubMenuItem subMenuItem = SubMenuItem.fromOption(inputSubMenu);
                subMenuItem.getMethod().accept(data, menuItem);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + System.lineSeparator());
            }
        } catch (IOException ioe) {
            System.out.println("IO error trying to read your input!\r\n");
        }
    }

    private void grades() {
        System.out.println("Proszę wybrać sub menu dla wybranej opcji: ");

        for (SubMenuItemGrades subMenuItemGrades : SubMenuItemGrades.values()) {
            System.out.format("%s. %s", subMenuItemGrades.getOption(), subMenuItemGrades.getLabel());
            System.out.println();
        }

        try {
            int inputSubMenuGrades = Integer.parseInt(bufferedReader.readLine());
            System.out.println("Wybrałeś " + inputSubMenuGrades + "\r\n");

            try {
                SubMenuItemGrades subMenuItemGrades = SubMenuItemGrades.fromOption(inputSubMenuGrades);
                subMenuItemGrades.getMethod().accept(data);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + System.lineSeparator());
            }
        } catch (IOException ioe) {
            System.out.println("IO error trying to read your input!\r\n");
        }
    }
}

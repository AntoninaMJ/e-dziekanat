package pl.edu.pg.dean.office.data;

import java.util.ArrayList;
import java.util.List;

public class Subject implements Saveable {

    private static final String SUBJECT_FILE = "subjects.txt";

    private String name;
    private Integer ECTS_points;

    public Subject(String name, Integer ECTS_points) {
        this.name = name;
        this.ECTS_points = ECTS_points;
    }

    public String getName() {
        return name;
    }

    public Integer getECTS_points() {
        return ECTS_points;
    }

    public void info() {
        System.out.println(toString());
    }

    @Override
    public String getFileName() {
        return SUBJECT_FILE;
    }

    @Override
    public List<String> getDataToSave() {
        List<String> data = new ArrayList<>();
        data.add(this.name);
        data.add(String.valueOf(this.ECTS_points));
        return data;

    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nazwa przedmiotu: ");
        sb.append(name);
        sb.append(System.lineSeparator());
        sb.append("punkty ECTS: ");
        sb.append(String.valueOf(ECTS_points));

        return sb.toString();
    }
}
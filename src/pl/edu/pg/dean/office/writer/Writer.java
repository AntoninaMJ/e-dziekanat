package pl.edu.pg.dean.office.writer;

import pl.edu.pg.dean.office.data.Saveable;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Klasa ktora zapisuje rozne obiekty w rozne miejsca
 */


public class Writer {

    private Map<String, BufferedWriter> writers = new HashMap<>();

    public void saveAll(List<? extends Saveable> saveables) {
        for (Saveable saveable : saveables) {
            save(saveable);
        }
    }

    public void save(Saveable s) {
        try {
            BufferedWriter bw = getWriter(s.getFileName());
            List<String> getDataToSave = s.getDataToSave();
            for (String data : getDataToSave) {
                bw.write(data);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Problem z plikiem" + s.getFileName());
        }
    }

    public void closeWriters() throws IOException {
        for (BufferedWriter writer : writers.values()) {
            writer.close();
        }
        writers.clear();
    }

    private BufferedWriter getWriter(String fileName) throws IOException {
        if (writers.containsKey(fileName)) {
            return writers.get(fileName);
        } else {
            File output = new File(fileName);
            BufferedWriter writer = new BufferedWriter(new FileWriter(output, false));
            writers.put(fileName, writer);
            return writer;
        }
    }
}
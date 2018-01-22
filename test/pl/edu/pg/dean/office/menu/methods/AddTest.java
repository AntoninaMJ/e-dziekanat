package pl.edu.pg.dean.office.menu.methods;

import org.junit.jupiter.api.Test;
import pl.edu.pg.dean.office.DeanOfficeData;
import pl.edu.pg.dean.office.data.person.Student;
import pl.edu.pg.dean.office.data.person.StudentStatus;
import pl.edu.pg.dean.office.menu.MenuItem;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddTest {

    @Test
    public void shouldAddStudent() {
        InputStream stdin = System.in;

        String firstName = "Jan";
        String lastName = "Kowalski";
        Long pesel = 123456789L;
        String albumNumber = "987654";

        String input = firstName;
        input += System.lineSeparator();
        input += lastName;
        input += System.lineSeparator();
        input += pesel;
        input += System.lineSeparator();
        input += albumNumber;

        try {
            System.setIn(new ByteArrayInputStream(input.getBytes()));

            DeanOfficeData data = new DeanOfficeData();
            data.setStudents(new ArrayList<>());
            Add.add(data, MenuItem.STUDENTS);

            assertTrue(data.getStudents().size() == 1);

            Student student = data.getStudents().get(0);

            assertEquals(student.getStatus(), StudentStatus.ACTIVE);
            assertEquals(student.getFirstName(), firstName);
            assertEquals(student.getLastName(), lastName);
            assertEquals(student.getPesel(), pesel);
            assertEquals(student.getAlbumNumber(), albumNumber);
        } finally {
            System.setIn(stdin);
        }
    }
}
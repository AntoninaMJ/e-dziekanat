package pl.edu.pg.dean.office.data.person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student extends Person {

    private static Integer studentCount = 0;

    private static final String STUDENT_FILE = "students.txt";

    private Integer id;
    private String albumNumber;
    private StudentStatus status = StudentStatus.ACTIVE;

    public Student(String first_name, String last_name, Long pesel, String albumNumber) {
        super(first_name, last_name, pesel);
        this.albumNumber = albumNumber;
        this.id = studentCount++;
    }

    public String getAlbumNumber() {
        return albumNumber;
    }

    public void setAlbumNumber(String albumNumber) {
        this.albumNumber = albumNumber;
    }

    public StudentStatus getStatus() {
        return status;
    }

    public void setStatus(StudentStatus status) {
        this.status = status;
    }

    @Override
    public void info() {
        System.out.println(toString());
    }

    @Override
    public String getFileName() {
        return STUDENT_FILE;
    }

    @Override
    public List<String> getDataToSave() {
        List<String> data = new ArrayList<>();
        return Arrays.asList(String.valueOf(id), this.firstName, this.lastName, String.valueOf(pesel), this.albumNumber, this.status.name());
    }


    @Override
    public String toString() {
        String result = "Student: " + id + ", " + System.lineSeparator();
        result += "imię: " + firstName + ", " + System.lineSeparator();
        result += "nazwisko: " + lastName + ", " + System.lineSeparator();
        result += "pesel: " + pesel + ", " + System.lineSeparator();
        result += "album: " + albumNumber + ", " + System.lineSeparator();
        result += status.getValueEN() + System.lineSeparator();
        return result;
    }


    @Override
    public boolean equals(Object o) {
        boolean res = false;
        if (o instanceof Student) {
            Student st = (Student) o;
            if (st.getPesel().equals(this.pesel)) {
                res = true;
            }
        }
        return super.equals(o);
    }
}

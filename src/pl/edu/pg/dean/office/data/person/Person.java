package pl.edu.pg.dean.office.data.person;

import pl.edu.pg.dean.office.data.Saveable;

public abstract class Person implements Saveable {

    protected String firstName;
    protected String lastName;
    protected Long pesel;

    public Person(String firstName, String lastName, Long pesel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
    }

    public abstract void info();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getPesel() {
        return pesel;
    }

    public void setPesel(Long pesel) {
        this.pesel = pesel;
    }
}


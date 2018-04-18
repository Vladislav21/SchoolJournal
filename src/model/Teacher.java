package model;

import java.io.Serializable;

public class Teacher implements Person, Serializable {

    private int id;
    private String firstName;
    private String lastName;
    private String nameSchoolSubject;

    public Teacher() {
    }

    public Teacher(int id, String firstName, String lastName, String nameSchoolSubject) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nameSchoolSubject = nameSchoolSubject;
    }

    public Teacher(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public int getId() {
        return id;
    }

    public String getNameSchoolSubject() {
        return nameSchoolSubject;
    }

    public void setNameSchoolSubject(String nameSchoolSubject) {
        this.nameSchoolSubject = nameSchoolSubject;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nameSchoolSubject='" + nameSchoolSubject + '\'' +
                '}';
    }
}

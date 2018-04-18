package model;

import java.io.Serializable;

public class Student implements Person,Serializable {

    private int id;
    private String firstName;
    private String lastName;
    private String nameSchoolClass;

    public Student() {
    }

    public Student(int id, String firstName, String lastName, String nameSchoolClass) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nameSchoolClass = nameSchoolClass;
    }

    public Student(int id, String firstName, String lastName) {
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

    public String getNameSchoolClass() {
        return nameSchoolClass;
    }

    public void setNameSchoolClass(String nameSchoolClass) {
        this.nameSchoolClass = nameSchoolClass;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nameSchoolClass='" + nameSchoolClass + '\'' +
                '}';
    }
}

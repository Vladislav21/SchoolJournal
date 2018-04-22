package model;

import java.io.Serializable;

public class Student implements Person, Serializable {

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

    @Override
    public String getAttachmentToClassOrSubject() {
        return nameSchoolClass;
    }

    @Override
    public void setAttachmentToClassOrSubject(String name) {
        this.nameSchoolClass = name;
    }

    @Override
    public String toString() {
        return "Студент:" +
                " ID = " + id +
                ", Имя = " + firstName +
                ", Фамилия = " + lastName +
                ", Школьный класс = " + nameSchoolClass + ";\n";
    }
}

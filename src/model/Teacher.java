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
        return nameSchoolSubject;
    }

    @Override
    public void setAttachmentToClassOrSubject(String name) {
        this.nameSchoolSubject = name;
    }

    @Override
    public String toString() {
        return "Учитель:" +
                " ID = " + id +
                ", Имя = " + firstName +
                ", Фамилия = " + lastName +
                ", Школьный предмет = " + nameSchoolSubject + ";\n";
    }
}

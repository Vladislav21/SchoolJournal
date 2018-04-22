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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher teacher = (Teacher) o;

        if (id != teacher.id) return false;
        if (firstName != null ? !firstName.equals(teacher.firstName) : teacher.firstName != null) return false;
        if (lastName != null ? !lastName.equals(teacher.lastName) : teacher.lastName != null) return false;
        return nameSchoolSubject != null ? nameSchoolSubject.equals(teacher.nameSchoolSubject) : teacher.nameSchoolSubject == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (nameSchoolSubject != null ? nameSchoolSubject.hashCode() : 0);
        return result;
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

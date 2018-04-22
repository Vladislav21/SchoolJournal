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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        if (firstName != null ? !firstName.equals(student.firstName) : student.firstName != null) return false;
        if (lastName != null ? !lastName.equals(student.lastName) : student.lastName != null) return false;
        return nameSchoolClass != null ? nameSchoolClass.equals(student.nameSchoolClass) : student.nameSchoolClass == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (nameSchoolClass != null ? nameSchoolClass.hashCode() : 0);
        return result;
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

package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SchoolClass implements Serializable {
    private int id;
    private String name;
    private List<Person> students;
    private Teacher teacher;

    public SchoolClass() {
        students = new ArrayList<>();
    }

    public SchoolClass(int id, String name, List<Person> students, Teacher teacher) {
        this.id = id;
        this.name = name;
        this.students = students;
        this.teacher = teacher;
    }

    public SchoolClass(int id, String name, Teacher teacher) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
    }

    public int getId() {
        return id;
    }

    public List<Person> getStudents() {
        return students;
    }

    public void setStudents(List<Person> students) {
        this.students = students;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "\nSchoolClass: " +
                "name = '" + name + '\'' +
                "students = " + students +
                "classroom teacher = " + teacher +
                '}' + "\n";
    }
}

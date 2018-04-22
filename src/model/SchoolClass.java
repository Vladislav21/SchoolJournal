package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SchoolClass implements Serializable {
    private int id;
    private String name;
    private List<Person> students;
    private Teacher teacher;
    private List<Journal> journals;

    public SchoolClass() {
        students = new ArrayList<>();
        journals = new ArrayList<>();
    }

    public SchoolClass(int id, String name, List<Person> students, Teacher teacher, List<Journal> journals) {
        this.id = id;
        this.name = name;
        this.students = students;
        this.teacher = teacher;
        this.journals = journals;
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

    public List<Journal> getJournals() {
        return journals;
    }

    public void setJournals(List<Journal> journals) {
        this.journals = journals;
    }

    @Override
    public String toString() {
        return "\nШкольный класс:" +
                " ID = " + id +
                ", Название = " + name +
                ",\nСтуденты: \n" + students +
                ",\nЖурналы: \n" + journals +
                ",\nКлассный руководитель = " + teacher +
                "*********************************************************************************************************";
    }
}

package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SchoolClass implements Serializable {
    private int id;
    private String name;
    private List<Person> students;
    private List<Person> teachers;
    private List<Journal> journals;

    public SchoolClass() {
        students = new ArrayList<>(4);
        journals = new ArrayList<>();
        teachers = new ArrayList<>();
    }

    public SchoolClass(int id, String name, List<Person> students, List<Person> teachers, List<Journal> journals) {
        this.id = id;
        this.name = name;
        this.students = students;
        this.teachers = teachers;
        this.journals = journals;
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

    public List<Person> getTeacheres() {
        return teachers;
    }

    public void setTeacheres(List<Person> teachers) {
        this.teachers = teachers;
    }

    public List<Journal> getJournals() {
        return journals;
    }

    public void setJournals(List<Journal> journal) {
        this.journals = journal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "\nSchoolClass: " +
                "name = '" + name + '\'' +
                ", journals = " + journals +
                '}'+"\n";
    }
}

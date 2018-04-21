package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class School implements Serializable {
    private List<SchoolClass> schoolClasses;
    private List<Person> teachers;
    private List<Person> students;
    private List<SchoolSubject> schoolSubjects;
    private List<Journal> journals;

    public School() {
        schoolClasses = new ArrayList<>();
        teachers = new ArrayList<>();
        schoolSubjects = new ArrayList<>();
        journals = new ArrayList<>();
        students = new ArrayList<>();
    }

    public School(List<SchoolClass> schoolClasses, List<Person> teachers, List<Person> students, List<SchoolSubject> schoolSubjects, List<Journal> journals) {
        this.schoolClasses = schoolClasses;
        this.teachers = teachers;
        this.students = students;
        this.schoolSubjects = schoolSubjects;
        this.journals = journals;
    }

    public List<SchoolClass> getSchoolClasses() {
        return schoolClasses;
    }

    public void setSchoolClasses(List<SchoolClass> schoolClasses) {
        this.schoolClasses = schoolClasses;
    }

    public List<Person> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Person> teachers) {
        this.teachers = teachers;
    }

    public List<SchoolSubject> getSchoolSubjects() {
        return schoolSubjects;
    }

    public void setSchoolSubjects(List<SchoolSubject> schoolSubjects) {
        this.schoolSubjects = schoolSubjects;
    }

    public List<Journal> getJournals() {
        return journals;
    }

    public void setJournals(List<Journal> journals) {
        this.journals = journals;
    }

    public List<Person> getStudents() {
        return students;
    }

    public void setStudents(List<Person> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "\nSchool: " +
                "schoolClasses = " + schoolClasses +
                "teachers = " + teachers +
                "schoolSubjects = " + schoolSubjects +
                "journals = " + journals +
                "students = " + students +
                '}' + "\n";
    }
}

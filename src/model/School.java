package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class School implements Serializable {
    private List<SchoolClass> schoolClasses;
    private List<Person> teachers;
    private List<Person> students;
    private List<SchoolSubject> schoolSubjects;

    public School() {
        schoolClasses = new ArrayList<>();
        teachers = new ArrayList<>();
        schoolSubjects = new ArrayList<>();
        students = new ArrayList<>();
    }

    public School(List<SchoolClass> schoolClasses, List<Person> teachers, List<Person> students, List<SchoolSubject> schoolSubjects) {
        this.schoolClasses = schoolClasses;
        this.teachers = teachers;
        this.students = students;
        this.schoolSubjects = schoolSubjects;

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

    public List<Person> getStudents() {
        return students;
    }

    public void setStudents(List<Person> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "\t\t\t\t\t\t\t\t\t\t\t\tШКОЛА. " +
                "\nШКОЛЬНЫЕ КЛАССЫ: \n" + schoolClasses +
                "\n\nУЧИТЕЛЯ: \n" + teachers +
                "\n\nШКОЛЬНЫЕ ПРЕДМЕТЫ: \n" + schoolSubjects +
                "\n\nСТУДЕНТЫ: \n" + students;
    }
}

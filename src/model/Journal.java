package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Journal implements Serializable {
    private int id;
    private List<Mark> marks;
    private SchoolSubject schoolSubject;

    public Journal() {
        marks = new ArrayList<>();
    }

    public Journal(int id, List<Mark> marks, SchoolSubject schoolSubject) {
        this.id = id;
        this.marks = marks;
        this.schoolSubject = schoolSubject;
    }

    public Journal(int id, SchoolSubject schoolSubject) {
        this.id = id;
        this.schoolSubject = schoolSubject;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public void setMarks(List<Mark> marks) {
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public SchoolSubject getSchoolSubject() {
        return schoolSubject;
    }

    public void setSchoolSubject(SchoolSubject schoolSubject) {
        this.schoolSubject = schoolSubject;
    }

    @Override
    public String toString() {
        return "\nЖурнал: " +
                "ID журнала = " + id + ", " +
                schoolSubject +
                "Оценки: \n" + marks + "\n";
    }
}

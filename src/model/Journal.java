package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Journal implements Serializable {
    private int id;
    private List<Mark> marks;
    private String nameSubject;

    public Journal() {
        marks = new ArrayList<>();
    }

    public Journal(int id, List<Mark> marks, String nameSubject) {
        this.id = id;
        this.marks = marks;
        this.nameSubject = nameSubject;
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

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public void increamentId(){
        this.id++;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "marks=" + marks +
                ", nameSubject='" + nameSubject + '\'' +
                '}';
    }
}

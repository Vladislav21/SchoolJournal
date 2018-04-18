package model;

import java.io.Serializable;
import java.util.Calendar;

public class Mark implements Serializable {
    private int id;
    private int value;
    private Calendar calendar;
    private Person student;
    private Person teacher;
    private SchoolSubject slsub;

    public Mark() {
    }

    public Mark(int id, int value, Calendar calendar, Person student, Person teacher, SchoolSubject slsub) {
        this.id = id;
        this.value = value;
        this.calendar = calendar;
        this.student = student;
        this.teacher = teacher;
        this.slsub = slsub;
    }

    public int getId() {
        return id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public Person getStudent() {
        return student;
    }

    public void setStudent(Person student) {
        this.student = student;
    }

    public Person getTeacher() {
        return teacher;
    }

    public void setTeacher(Person teacher) {
        this.teacher = teacher;
    }

    public SchoolSubject getSlsub() {
        return slsub;
    }

    public void setSlsub(SchoolSubject slsub) {
        this.slsub = slsub;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "value=" + value +
                ", calendar=" + calendar.getTime() +
                ", student=" + student +
                ", teacher=" + teacher +
                ", slsub=" + slsub +
                '}';
    }
}

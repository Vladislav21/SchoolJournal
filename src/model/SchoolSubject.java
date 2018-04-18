package model;

import java.io.Serializable;

public class SchoolSubject implements Serializable {
    private int id;
    private String name;
    private int temporaryLoad;

    public SchoolSubject() {
    }

    public SchoolSubject(int id, String name, int temporaryLoad) {
        this.id = id;
        this.name = name;
        this.temporaryLoad = temporaryLoad;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTemporaryLoad() {
        return temporaryLoad;
    }

    public void setTemporaryLoad(int temporaryLoad) {
        this.temporaryLoad = temporaryLoad;
    }

    @Override
    public String toString() {
        return "SchoolSubject{" +
                "name='" + name + '\'' +
                ", temporaryLoad=" + temporaryLoad +
                '}';
    }
}

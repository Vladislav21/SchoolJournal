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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SchoolSubject that = (SchoolSubject) o;

        if (id != that.id) return false;
        if (temporaryLoad != that.temporaryLoad) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + temporaryLoad;
        return result;
    }

    @Override
    public String toString() {
        return "SchoolSubject{" +
                "name = '" + name + '\'' +
                ", temporaryLoad = " + temporaryLoad + " hours" +
                '}' + "\n";
    }
}

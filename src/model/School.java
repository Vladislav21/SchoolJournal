package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class School implements Serializable{
    private List<SchoolClass> schoolClasses;

    public School() {
        schoolClasses = new ArrayList<>();
    }

    public School(List<SchoolClass> schoolClasses) {
        this.schoolClasses = schoolClasses;
    }

    public List<SchoolClass> getSchoolClasses() {
        return schoolClasses;
    }

    public void setSchoolClasses(List<SchoolClass> schoolClasses) {
        this.schoolClasses = schoolClasses;
    }

    @Override
    public String toString() {
        return "\nSchool{" +
                "schoolClasses=" + schoolClasses +
                '}'+"\n";
    }
}

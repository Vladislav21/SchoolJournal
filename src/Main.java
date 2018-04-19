
import model.*;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        School school = new School();
        List<Person> students = Arrays.asList(new Student(1, "Михаил", "Иванов", "5B")
                , new Student(2, "Ольга", "Иванова", "5B")
                , new Student(3, "Катя", "Смирнова", "5B"));
        List<Person> teachers = Arrays.asList(new Teacher(1, "Надежда", "Петрова", "Математика")
                , new Teacher(2, "Ольга", "Кательникова", "Русский язык")
                , new Teacher(3, "Стас", "Петрова", "Химия"));
        List<Mark> marks = Arrays.asList(new Mark(1, 4, Calendar.getInstance(), students.get(0), teachers.get(1))
                , new Mark(1, 4, Calendar.getInstance(), students.get(1), teachers.get(0)));
        List<Mark> marks1 = Arrays.asList(new Mark(1, 4, Calendar.getInstance(), students.get(0), teachers.get(1))
                , new Mark(1, 4, Calendar.getInstance(), students.get(1), teachers.get(0)));
        List<Journal> journals = Arrays.asList(new Journal(1, marks, new SchoolSubject(1, "Математика", 245))
                , new Journal(2, marks1, new SchoolSubject(2, "Химия", 245)));
        school.getSchoolClasses().add(new SchoolClass(1, "5B", students, teachers, journals));
     /*   journals.get(0).getMarks().forEach(System.out::println);
        students.forEach(System.out::println);
        teachers.forEach(System.out::println);
        journals.forEach(System.out::println);*/
        school.getSchoolClasses().forEach(System.out::println);

    }
}

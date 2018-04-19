package controller;

import model.*;
import model.myException.*;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.Calendar;
import java.util.List;

public class Controller {
    private static final String FILE_NAME = "SchoolData.dat";
    private static Logger logger = Logger.getLogger(Controller.class.getSimpleName());

    private File file;
    private School school;
    private PersonFabric studentFabric;
    private int idMark;
    private int idStudent;
    private int idJournal;


    public Controller() {
        file = new File(FILE_NAME);
        school = new School();
        idMark = 0;
        idStudent = 0;
        idJournal = 0;
        studentFabric = new StudentFabric();
    }

    public void readData() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            school = (School) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            logger.error(e);
        } finally {
            try {
                if (fis != null && ois != null) {
                    fis.close();
                    ois.close();
                }
            } catch (IOException e) {
                logger.error(e);
            }
        }
    }

    public void saveData() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(school);
        } catch (IOException e) {
            logger.error(e);
        } finally {
            try {
                if (fos != null && oos != null) {
                    fos.close();
                    oos.close();
                }
            } catch (IOException e) {
                logger.error(e);
            }
        }
    }

    public boolean addMark(int value, Person student, Person teacher, SchoolSubject schoolSubject, String nameClass) {
        boolean isAdded = false;
        try {
            SchoolClass schoolClass = school.getSchoolClasses().stream().filter(c -> c.getName().equals(nameClass))
                    .findFirst().orElseThrow(() -> new SchoolClassNotFoundException("This school class is absent"));
            Journal journal = schoolClass.getJournals().stream().filter(j -> j.getSchoolSubject().equals(schoolSubject))
                    .findFirst().orElseThrow(() -> new JournalClassNotFoundException("This journal class is absent"));
            if (value >= 0 && value <= 5) {
                idMark++;
                isAdded = journal.getMarks().add(new Mark(idMark, value, Calendar.getInstance(), student, teacher));
            } else {
                throw new InvalidValueOfMarkException("This mark is invalid");
            }
        } catch (SchoolObjectNotException | InvalidSchoolValueException e) {
            logger.error(e);
        }
        return isAdded;
    }

    public void getMarks(String nameClass, String nameSubject) {
        try {
            SchoolClass schoolClass = school.getSchoolClasses().stream().filter(c -> c.getName().equals(nameClass))
                    .findFirst().orElseThrow(() -> new SchoolClassNotFoundException("This school class is absent"));
            Journal journal = schoolClass.getJournals().stream().filter(j -> j.getSchoolSubject().getName().equals(nameSubject))
                    .findFirst().orElseThrow(() -> new JournalClassNotFoundException("This journal class is absent"));
            journal.getMarks().forEach(System.out::println);
        } catch (SchoolObjectNotException e) {
            logger.error(e);
        }
    }

    public boolean editMark(String nameClass, String nameSubject, String fnStudent, String lnStudent, int value) {
        boolean isEdited = false;
        try {
            SchoolClass schoolClass = school.getSchoolClasses().stream().filter(c -> c.getName().equals(nameClass))
                    .findFirst().orElseThrow(() -> new SchoolClassNotFoundException("This school class is absent"));
            Journal journal = schoolClass.getJournals().stream().filter(j -> j.getSchoolSubject().getName().equals(nameSubject))
                    .findFirst().orElseThrow(() -> new JournalClassNotFoundException("This journal class is absent"));
            Mark mark = journal.getMarks().stream().filter(m -> m.getStudent().getFirstName().equals(fnStudent) && m.getStudent().getLastName().equals(lnStudent))
                    .findFirst().orElseThrow(() -> new MarkNotFoundException(" The mark with this student is absent"));
            if (value >= 0 && value <= 5) {
                mark.setValue(value);
                isEdited = true;
            } else {
                throw new InvalidValueOfMarkException("This mark is invalid");
            }
        } catch (SchoolObjectNotException | InvalidSchoolValueException e) {
            logger.error(e);
        }
        return isEdited;
    }

    public boolean deleteMark(String nameClass, String nameSubject, String fnStudent, String lnStudent) {
        boolean isDeleted = false;
        try {
            SchoolClass schoolClass = school.getSchoolClasses().stream().filter(c -> c.getName().equals(nameClass))
                    .findFirst().orElseThrow(() -> new SchoolClassNotFoundException("This school class is absent"));
            Journal journal = schoolClass.getJournals().stream().filter(j -> j.getSchoolSubject().getName().equals(nameSubject))
                    .findFirst().orElseThrow(() -> new JournalClassNotFoundException("This journal class is absent"));
            Mark mark = journal.getMarks().stream().filter(m -> m.getStudent().getFirstName().equals(fnStudent) && m.getStudent().getLastName().equals(lnStudent))
                    .findFirst().orElseThrow(() -> new MarkNotFoundException("The mark with this student is absent"));
            isDeleted = journal.getMarks().remove(mark);
        } catch (SchoolObjectNotException e) {
            logger.error(e);
        }
        return isDeleted;
    }

    public boolean editStudent(String nameClass, String fnStudent, String lnStudent, String nfnStudent, String nlnStudent) {
        boolean isEdited = false;
        try {
            SchoolClass schoolClass = school.getSchoolClasses().stream().filter(c -> c.getName().equals(nameClass))
                    .findFirst().orElseThrow(() -> new SchoolClassNotFoundException("This school class is absent"));
            Student student = (Student) schoolClass.getStudents().stream().filter(s -> s.getFirstName().equals(fnStudent) && s.getLastName().equals(lnStudent))
                    .findFirst().orElseThrow(() -> new StudentNotFoundException("This student is absent"));
            student.setFirstName(nfnStudent);
            student.setLastName(nlnStudent);
            isEdited = true;
        } catch (SchoolObjectNotException e) {
            logger.error(e);
        }
        return isEdited;
    }

    public Student addStudent(String nameClass, String fnStudent, String lnStudent) {
        Student student = null;
        try {
            SchoolClass schoolClass = school.getSchoolClasses().stream().filter(c -> c.getName().equals(nameClass))
                    .findFirst().orElseThrow(() -> new SchoolClassNotFoundException("This school class is absent"));
            if (schoolClass.getStudents().size() < 4) {
                idStudent++;
                student = (Student) studentFabric.createPerson(idStudent, fnStudent, lnStudent);
                student.setNameSchoolClass(nameClass);
                schoolClass.getStudents().add(student);
            } else {
                throw new IndexOutOfBoundsException();
            }
        } catch (SchoolObjectNotException e) {
            logger.error(e);
        }
        return student;
    }

    public boolean deleteStudent(String nameClass, String fnStudent, String lnStudent) {
        boolean isDeleted = false;
        try {
            SchoolClass schoolClass = school.getSchoolClasses().stream().filter(c -> c.getName().equals(nameClass))
                    .findFirst().orElseThrow(() -> new SchoolClassNotFoundException("This school class is absent"));
            Student student = (Student) schoolClass.getStudents().stream().filter(s -> s.getFirstName().equals(fnStudent) && s.getLastName().equals(lnStudent))
                    .findFirst().orElseThrow(() -> new StudentNotFoundException("This student is absent"));
            isDeleted = schoolClass.getStudents().remove(student);
        } catch (SchoolObjectNotException e) {
            logger.error(e);
        }
        return isDeleted;
    }

    public boolean addJournal(String nameClass, SchoolSubject schoolSubject) {
        boolean isAdded = false;
        try {
            SchoolClass schoolClass = school.getSchoolClasses().stream().filter(c -> c.getName().equals(nameClass))
                    .findFirst().orElseThrow(() -> new SchoolClassNotFoundException("This school class is absent"));
            boolean isHaving = schoolClass.getJournals().stream().anyMatch(j -> j.getSchoolSubject().equals(schoolSubject));
            if (isHaving) {
                throw new InvalidValueOfSchoolSubjectException("This schoolSubject already exists");
            } else {
                idJournal++;
                Journal journal = new Journal(idJournal, schoolSubject);
                isAdded = schoolClass.getJournals().add(journal);
            }
        } catch (SchoolObjectNotException | InvalidSchoolValueException e) {
            logger.error(e);
        }
        return isAdded;
    }

    public void getJournals(String nameClass) {
        try {
            SchoolClass schoolClass = school.getSchoolClasses().stream().filter(c -> c.getName().equals(nameClass))
                    .findFirst().orElseThrow(() -> new SchoolClassNotFoundException("This school class is absent"));
            schoolClass.getJournals().forEach(System.out::println);
        } catch (SchoolObjectNotException e) {
            logger.error(e);
        }
    }
}

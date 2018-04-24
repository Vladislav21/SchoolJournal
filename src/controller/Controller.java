package controller;

import model.*;
import model.myException.*;
import org.apache.log4j.Logger;

import javax.naming.SizeLimitExceededException;
import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Controller {
    private static final String FILE_NAME = "SchoolData.dat";
    private static Logger logger = Logger.getLogger(Controller.class.getSimpleName());

    private File file;
    private School school;
    private PersonFabric studentFabric;
    private PersonFabric teacherFabric;
    private int idMark;
    private int idStudent;
    private int idJournal;
    private int idSchoolSubject;
    private int idTeacher;
    private int idSchoolClass;

    public Controller() {
        file = new File(FILE_NAME);
        school = new School();
        idMark = 0;
        idStudent = 0;
        idJournal = 0;
        idSchoolSubject = 0;
        idTeacher = 0;
        idSchoolClass = 0;
        studentFabric = new StudentFabric();
        teacherFabric = new TeacherFabric();
    }

    public School readData() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            school = (School) ois.readObject();
            return school;
        } catch (IOException | ClassNotFoundException e) {
            logger.warn(e);
        } finally {
            try {
                if (fis != null && ois != null) {
                    fis.close();
                    ois.close();
                }
            } catch (IOException e) {
                logger.warn(e);
            }
        }
        return null;
    }

    public void saveData() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(school);
        } catch (IOException e) {
            logger.warn(e);
        } finally {
            try {
                if (fos != null && oos != null) {
                    fos.close();
                    oos.close();
                }
            } catch (IOException e) {
                logger.warn(e);
            }
        }
    }

    public void addSubject(String nameSubject, int temporaryLoad) {
        try {
            if (school.getSchoolSubjects().stream().noneMatch(schoolSubject -> schoolSubject.getName().equals(nameSubject))) {
                idSchoolSubject++;
                school.getSchoolSubjects().add(new SchoolSubject(idSchoolSubject, nameSubject, temporaryLoad));
            } else {
                throw new InvalidValueOfSchoolSubjectException("This subject already exists");
            }
        } catch (InvalidSchoolValueException e) {
            logger.warn(e);
        }
    }

    public void addTeacher(String fnTeacher, String lnTeacher, String nameSchoolSubject) {
        try {
            if (school.getSchoolSubjects().stream().anyMatch(schoolSubject -> schoolSubject.getName().equals(nameSchoolSubject))) {
                idTeacher++;
                school.getTeachers().add(teacherFabric.createPerson(idTeacher, fnTeacher, lnTeacher, nameSchoolSubject));
            } else {
                throw new InvalidValueOfSchoolSubjectException("This subject is absent");
            }
        } catch (InvalidSchoolValueException e) {
            logger.warn(e);
        }
    }

    public void addSchoolClass(String name, int teacherId) {
        try {
            Teacher teacher = (Teacher) school.getTeachers().stream().filter(t -> t.getId() == teacherId)
                    .findFirst().orElseThrow(() -> new TeacherNotFoundException("This teacher is absent"));
            idSchoolClass++;
            List<Person> students = new ArrayList<>();
            List<Journal> journals = new ArrayList<>();
            school.getSchoolClasses().add(new SchoolClass(idSchoolClass, name, students, teacher, journals));
        } catch (SchoolObjectNotException e) {
            logger.warn(e);
        }
    }

    public boolean addStudent(String fnStudent, String lnStudent, String nameSchoolClass) {
        try {
            SchoolClass schoolClass = school.getSchoolClasses().stream().filter(schclass -> schclass.getName().equals(nameSchoolClass))
                    .findFirst().orElseThrow(() -> new SchoolClassNotFoundException("This school class is absent"));
            if (schoolClass.getStudents().size() < 4) {
                idStudent++;
                Student student = (Student) studentFabric.createPerson(idStudent, fnStudent, lnStudent, nameSchoolClass);
                schoolClass.getStudents().add(student);
                school.getStudents().add(student);
                return true;
            } else {
                throw new SizeLimitExceededException("The school class is full");
            }
        } catch (SizeLimitExceededException | SchoolObjectNotException e) {
            logger.warn(e);
        }
        return false;
    }

    public boolean addJournal(int schoolSubjectId, int schoolClassId) {
        try {
            SchoolSubject schoolSub = school.getSchoolSubjects().stream().filter(schoolSubject -> schoolSubject.getId() == schoolSubjectId)
                    .findFirst().orElseThrow(() -> new SchoolSubjectNotFoundException("This subject is absent"));
            SchoolClass schoolClass = school.getSchoolClasses().stream().filter(schcl -> schcl.getId() == schoolClassId)
                    .findFirst().orElseThrow(() -> new SchoolClassNotFoundException("This school class is absent"));
            if (schoolClass.getJournals().stream().noneMatch(j -> j.getSchoolSubject().equals(schoolSub))) {
                idJournal++;
                List<Mark> marks = new ArrayList<>();
                return schoolClass.getJournals().add(new Journal(idJournal, marks, schoolSub));
            } else {
                throw new InvalidValueOfSchoolSubjectException("The journal already exists with this school subject");
            }
        } catch (SchoolObjectNotException | InvalidSchoolValueException e) {
            logger.warn(e);
        }
        return false;
    }

    public boolean addMark(int value, int day, int month, int studentId, int teacherId, int schoolSubjectId) {
        try {
            if (day < 1 || day > 30 || month < 1 || month > 12)
                throw new InvalidValueOfDateException("Values of date is not correct");
            if (value > 0 && value <= 5) {
                Student student = (Student) school.getStudents().stream().filter(stud -> stud.getId() == studentId)
                        .findFirst().orElseThrow(() -> new StudentNotFoundException("This student is absent"));
                Teacher teacher = (Teacher) school.getTeachers().stream().filter(t -> t.getId() == teacherId)
                        .findFirst().orElseThrow(() -> new TeacherNotFoundException("This teacher is absent"));
                SchoolSubject schoolSub = school.getSchoolSubjects().stream().filter(schoolSubject -> schoolSubject.getId() == schoolSubjectId)
                        .findFirst().orElseThrow(() -> new SchoolSubjectNotFoundException("This subject is absent"));
                SchoolClass schoolClass = school.getSchoolClasses().stream().filter(schcl -> schcl.getName().equals(student.getAttachmentToClassOrSubject()))
                        .findFirst().orElseThrow(() -> new SchoolClassNotFoundException("The school class is absent with this student"));
                Journal journal = schoolClass.getJournals().stream().filter(j -> j.getSchoolSubject().equals(schoolSub))
                        .findFirst().orElseThrow(() -> new JournalClassNotFoundException("This journal is absent"));
                idMark++;
                Calendar calendar = new GregorianCalendar(2018, month, day);
                return journal.getMarks().add(new Mark(idMark, value, calendar, student, teacher));
            } else {
                throw new InvalidValueOfMarkException("This mark is invalid");
            }
        } catch (InvalidSchoolValueException | SchoolObjectNotException e) {
            logger.warn(e);
        }
        return false;
    }

    public List<Journal> getJournals(int schoolClassId) {
        try {
            SchoolClass schoolClass = school.getSchoolClasses().stream().filter(schcl -> schcl.getId() == schoolClassId)
                    .findFirst().orElseThrow(() -> new SchoolClassNotFoundException("This school class is absent"));
            if (!schoolClass.getJournals().isEmpty()) {
                return schoolClass.getJournals();
            } else {
                throw new JournalClassNotFoundException("Journals are absent");
            }
        } catch (SchoolObjectNotException e) {
            logger.warn(e);
        }
        return null;
    }

    public List<Person> getStudents() {
        try {
            if (!school.getStudents().isEmpty()) {
                return school.getStudents();
            } else {
                throw new StudentNotFoundException("Students are absent");
            }
        } catch (SchoolObjectNotException e) {
            logger.warn(e);
        }
        return null;
    }

    public List<Mark> getMarks(String nameSubject, int schoolClassId) {
        try {
            SchoolSubject schoolSubject = school.getSchoolSubjects().stream().filter(ss -> ss.getName().equals(nameSubject))
                    .findFirst().orElseThrow(() -> new SchoolSubjectNotFoundException("This subject is absent"));
            SchoolClass schoolClass = school.getSchoolClasses().stream().filter(schcl -> schcl.getId() == schoolClassId)
                    .findFirst().orElseThrow(() -> new SchoolClassNotFoundException("This school class is absent"));
            Journal journal = schoolClass.getJournals().stream().filter(j -> j.getSchoolSubject().equals(schoolSubject))
                    .findFirst().orElseThrow(() -> new JournalClassNotFoundException("This journal is absent"));
            return journal.getMarks();
        } catch (SchoolObjectNotException e) {
            logger.warn(e);
        }
        return null;
    }

    public boolean deleteStudent(String fnStudent, String lnStudent, String nameClass) {
        try {
            Student student = (Student) school.getStudents().stream().filter(stud -> stud.getFirstName().equals(fnStudent) && stud.getLastName().equals(lnStudent))
                    .findFirst().orElseThrow(() -> new StudentNotFoundException("This student is absent"));
            school.getStudents().remove(student);
            return school.getSchoolClasses().stream().filter(ss -> ss.getName().equals(nameClass))
                    .findFirst().orElseThrow(() -> new SchoolClassNotFoundException("This school class is absent"))
                    .getStudents().remove(student);
        } catch (SchoolObjectNotException e) {
            logger.warn(e);
        }
        return false;
    }

    public boolean deleteMarkById(String nameSubject, int markId, int schoolClassId) {
        try {
            SchoolSubject schoolSubject = school.getSchoolSubjects().stream().filter(ss -> ss.getName().equals(nameSubject))
                    .findFirst().orElseThrow(() -> new SchoolSubjectNotFoundException("This subject is absent"));
            SchoolClass schoolClass = school.getSchoolClasses().stream().filter(schcl -> schcl.getId() == schoolClassId)
                    .findFirst().orElseThrow(() -> new SchoolClassNotFoundException("This school class is absent"));
            Journal journal = schoolClass.getJournals().stream().filter(j -> j.getSchoolSubject().equals(schoolSubject))
                    .findFirst().orElseThrow(() -> new JournalClassNotFoundException("This journal is absent"));
            Mark mark = journal.getMarks().stream().filter(m -> m.getId() == markId)
                    .findFirst().orElseThrow(() -> new MarkNotFoundException("Marks are absent with this ID"));
            return journal.getMarks().remove(mark);
        } catch (SchoolObjectNotException e) {
            logger.warn(e);
        }
        return false;
    }

    public boolean updateStudent(int studentId, String fnStudent, String lnStudent) {
        try {
            Student student = (Student) school.getStudents().stream().filter(stud -> stud.getId() == studentId)
                    .findFirst().orElseThrow(() -> new StudentNotFoundException("This student is absent"));
            student.setFirstName(fnStudent);
            student.setLastName(lnStudent);
            return true;
        } catch (SchoolObjectNotException e) {
            logger.warn(e);
        }
        return false;
    }

    public boolean updateMark(String nameSubject, int markId, int value, int day, int month, int schoolClassId) {
        try {
            if (day < 1 || day > 30 || month < 1 || month > 12)
                throw new InvalidValueOfDateException("Values of date is not correct");
            if (value > 0 && value <= 5) {
                SchoolSubject schoolSubject = school.getSchoolSubjects().stream().filter(ss -> ss.getName().equals(nameSubject))
                        .findFirst().orElseThrow(() -> new SchoolSubjectNotFoundException("This subject is absent"));
                SchoolClass schoolClass = school.getSchoolClasses().stream().filter(schcl -> schcl.getId() == schoolClassId)
                        .findFirst().orElseThrow(() -> new SchoolClassNotFoundException("This school class is absent"));
                Journal journal = schoolClass.getJournals().stream().filter(j -> j.getSchoolSubject().equals(schoolSubject))
                        .findFirst().orElseThrow(() -> new JournalClassNotFoundException("This journal is absent"));
                Mark mark = journal.getMarks().stream().filter(m -> m.getId() == markId)
                        .findFirst().orElseThrow(() -> new MarkNotFoundException("Marks are absent with this ID"));
                Calendar calendar = new GregorianCalendar(2018, month, day);
                mark.setValue(value);
                mark.setCalendar(calendar);
                return true;
            } else {
                throw new InvalidValueOfMarkException("This mark is invalid");
            }
        } catch (SchoolObjectNotException | InvalidSchoolValueException e) {
            logger.warn(e);
        }
        return false;
    }
}

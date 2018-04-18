package controller;

import model.*;
import model.MyException.JournalClassNotFoundException;
import model.MyException.SchoolClassNotFoundException;
import model.MyException.SchoolObjectNotException;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.Calendar;

public class Controller {
    private static final String FILE_NAME = "SchoolData.dat";
    private static Logger logger = Logger.getLogger(Controller.class.getSimpleName());

    private File file;
    private PersonFabric studentFabric;
    private PersonFabric teacherFabric;
    private School school;
    private int idMark;

    public Controller() {
        file = new File(FILE_NAME);
        studentFabric = new StudentFabric();
        teacherFabric = new TeacherFabric();
        school = new School();
        idMark = 0;
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
            Journal journal = schoolClass.getJournals().stream().filter(j -> j.getNameSubject().equals(schoolSubject.getName()))
                    .findFirst().orElseThrow(() -> new JournalClassNotFoundException("This journal class is absent"));
            idMark++;
            isAdded = journal.getMarks().add(new Mark(idMark, value, Calendar.getInstance(), student, teacher, schoolSubject));
        } catch (SchoolObjectNotException e) {
            logger.error(e);
        }
        return isAdded;
    }
}

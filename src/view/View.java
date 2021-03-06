package view;

import controller.Controller;
import model.School;
import model.myException.*;
import org.apache.log4j.Logger;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class View {
    private static Logger logger = Logger.getLogger(View.class.getSimpleName());
    private Controller controller;

    public View() {
        controller = new Controller();
    }

    public void startApp() {
        initialData();
        if (controller.readData() == null) {
            controller.saveData();
            School school = controller.readData();
            System.out.println(school.toString());
        } else {
            School school = controller.readData();
            System.out.println(school.toString());
        }
        boolean flag = true;
        while (flag) {
            menu();
            try {
                Scanner scanner = new Scanner(System.in);
                int selectAction = scanner.nextInt();
                switch (selectAction) {
                    case 1:
                        getSubjects();
                        menuForCreatingSubject(scanner);
                        System.out.println("Введите ID школьного предмета, по которому хотите добавить журнал:");
                        int schoolSubjectId = scanner.nextInt();
                        System.out.println("Введите ID школьного класса, которому будет принадлежать данный журнал:");
                        int schoolClassId = scanner.nextInt();
                        if (controller.addJournal(schoolSubjectId, schoolClassId)) {
                            logger.info("Журнал успешно добавлен");
                        } else {
                            menuForCreatingSubject(scanner);
                        }
                        break;
                    case 2:
                        System.out.println("Введите ID школьного класса, которому принадлежат  журналы:");
                        int schClssId = scanner.nextInt();
                        if (controller.getJournalsBySchoolClassId(schClssId) != null && !controller.getJournalsBySchoolClassId(schClssId).isEmpty()) {
                            controller.getJournalsBySchoolClassId(schClssId).forEach(System.out::println);
                        } else {
                            throw new JournalClassNotFoundException("Journals are not found");
                        }
                        break;
                    case 3:
                        System.out.println("Введите имя студента:");
                        String fnStudent = scanner.next();
                        System.out.println("Введите фамилию студента:");
                        String lnStudent = scanner.next();
                        System.out.println("Введите название класса, в котором будет данный студент:");
                        String nameSchoolClass = scanner.next();
                        if (controller.addStudent(fnStudent, lnStudent, nameSchoolClass))
                            logger.info("Студент успешно добавлен");
                        break;
                    case 4:
                        getStudents();
                        System.out.println("Введите имя студента, которого хотите удалить:");
                        String fsnmStudent = scanner.next();
                        System.out.println("Введите фамилию студента, которого хотите удалить:");
                        String lsnmStudent = scanner.next();
                        System.out.println("Введите название класса, в котором находится данный студент:");
                        String nameClassSchool = scanner.next();
                        if (controller.deleteStudent(fsnmStudent, lsnmStudent, nameClassSchool)) {
                            logger.info("Студент успешно удален");
                        } else {
                            logger.warn("Введенный класс не совпадает с классом студента");
                        }
                        break;
                    case 5:
                        getStudents();
                        System.out.println("Введите ID студента, которого хотите изменить:");
                        int studentId = scanner.nextInt();
                        System.out.println("Введите новое имя студента:");
                        String fsNameStudent = scanner.next();
                        System.out.println("Введите новую фамилию студента:");
                        String lsNameStudent = scanner.next();
                        if (controller.updateStudent(studentId, fsNameStudent, lsNameStudent))
                            logger.info("Студент успешно изменен");
                        break;
                    case 6:
                        getSubjects();
                        System.out.println("Введите название школьного предмета:");
                        String nameSubject = scanner.next();
                        System.out.println("Введите ID школьного класса:");
                        int schoolClssId = scanner.nextInt();
                        if (controller.getMarks(nameSubject, schoolClssId) != null && !controller.getMarks(nameSubject, schoolClssId).isEmpty()) {
                            controller.getMarks(nameSubject, schoolClssId).forEach(System.out::println);
                        } else {
                            throw new MarkNotFoundException("Marks are not found");
                        }
                        break;
                    case 7:
                        System.out.println("Введите оценку(1..5):");
                        int value = scanner.nextInt();
                        System.out.println("Введите месяц(1..12):");
                        int month = scanner.nextInt();
                        System.out.println("Введите число(1..30)");
                        int day = scanner.nextInt();
                        getStudents();
                        System.out.println("Введите ID студента, которому ставите оценку:");
                        int studentID = scanner.nextInt();
                        getTeachers();
                        System.out.println("Введите ID учителя, который ставит оценку:");
                        int teacherID = scanner.nextInt();
                        getSubjects();
                        System.out.println("Введите ID школьного предмета, по которому ставите оценку:");
                        int idSchoolSubject = scanner.nextInt();
                        if (controller.addMark(value, day, month, studentID, teacherID, idSchoolSubject))
                            logger.info("Оценка успешно добавлена");
                        break;
                    case 8:
                        System.out.println("Введите ID школьного класса:");
                        int scholClssId = scanner.nextInt();
                        getSubjects();
                        System.out.println("Введите название школьного предмета:");
                        String subjectName = scanner.next();
                        getSchoolJournalsBySchoolClassId(scholClssId);
                        System.out.println("Введите ID оценки");
                        int markId = scanner.nextInt();
                        if (controller.deleteMarkById(subjectName, markId, scholClssId))
                            logger.info("Оценка успешно удалена");
                        break;
                    case 9:
                        System.out.println("Введите ID школьного класса:");
                        int scholCssId = scanner.nextInt();
                        getSubjects();
                        System.out.println("Введите название школьного предмета:");
                        String subjeName = scanner.next();
                        getSchoolJournalsBySchoolClassId(scholCssId);
                        System.out.println("Введите ID оценки");
                        int mrkId = scanner.nextInt();
                        System.out.println("Введите оценку(1..5):");
                        int valueMark = scanner.nextInt();
                        System.out.println("Введите месяц(1..12):");
                        int mnth = scanner.nextInt();
                        System.out.println("Введите число(1..30)");
                        int dy = scanner.nextInt();
                        if (controller.updateMark(subjeName, mrkId, valueMark, dy, mnth, scholCssId))
                            logger.info("Оцена успешно изменена");
                        break;
                    case 10:
                        getStudents();
                        break;
                    case 11:
                        flag = false;
                        controller.saveData();
                        scanner.close();
                        break;
                    default:
                        System.out.println("Функции с таким номером не существует, повторите действие");
                        break;
                }
            } catch (NoSuchElementException | SchoolObjectNotException e) {
                logger.warn(e);
            }
        }
    }

    private void menu() {
        System.out.println("Школьный журнал. Выберите действие:" +
                "\n1 - Создать журнал" +
                "\n2 - Получить журналы" +
                "\n3 - Добавить студента" +
                "\n4 - Удалить студента" +
                "\n5 - Изменить студента" +
                "\n6 - Просмотреть оценки" +
                "\n7 - Добавить оценку" +
                "\n8 - Удалить оценку" +
                "\n9 - Изменить оценку" +
                "\n10 - Просмотреть студентов" +
                "\n11 - Выход");
    }

    private void menuForCreatingSubject(Scanner scanner) {
        boolean flag = true;
        while (flag) {
            System.out.println(
                    "Хотите добавить новый школьный предмет?" +
                            "\n1 - да" +
                            "\n2 - нет");
            int select = scanner.nextInt();
            switch (select) {
                case 1:
                    System.out.println("Введите название школьного предмета:");
                    String nameSubject = scanner.next();
                    System.out.println("Введите нагрузку в часах за четверть:");
                    int temporaryLoad = scanner.nextInt();
                    controller.addSubject(nameSubject, temporaryLoad);
                    logger.info("Создан новый школьный предмет");
                    flag = false;
                    break;
                case 2:
                    flag = false;
                    break;
                default:
                    System.out.println("Функции с таким номером не существует, повторите действие.");
                    break;
            }
        }
    }

    private void getSubjects() throws StudentNotFoundException {
        System.out.println("Школьные предметы, которые имеются в школе:\n");
        if (controller.getSchoolSubjects() != null && !controller.getSchoolSubjects().isEmpty()) {
            controller.getSchoolSubjects().forEach(System.out::println);
        } else {
            throw new StudentNotFoundException("School subjects are not found");
        }
    }

    private void getStudents() throws StudentNotFoundException {
        System.out.println("Все студенты в школе:\n");
        if (controller.getStudents() != null && !controller.getStudents().isEmpty()) {
            controller.getStudents().forEach(System.out::println);
        } else {
            throw new StudentNotFoundException("Students are not found");
        }
    }

    private void getTeachers() throws TeacherNotFoundException {
        System.out.println("Все учителя в школе:\n");
        if (controller.getTeachers() != null && !controller.getTeachers().isEmpty()) {
            controller.getTeachers().forEach(System.out::println);
        } else {
            throw new TeacherNotFoundException("Teachers are not found");
        }
    }

    private void getSchoolJournalsBySchoolClassId(int idSchoolClass) throws JournalClassNotFoundException {
        System.out.println("Все журналы по предметам для данного класса:\n");
        if (controller.getJournalsBySchoolClassId(idSchoolClass) != null && !controller.getJournalsBySchoolClassId(idSchoolClass).isEmpty()) {
            controller.getJournalsBySchoolClassId(idSchoolClass).forEach(System.out::println);
        } else {
            throw new JournalClassNotFoundException("Journals are not found");
        }
    }

    private void initialData() {
        controller.addSubject("Математика", 245);
        controller.addSubject("Физика", 345);
        controller.addSubject("Химия", 300);

        controller.addTeacher("Ольга", "Собчак", "Математика");
        controller.addTeacher("Стас", "Иванов", "Математика");
        controller.addTeacher("Андрей", "Смирнов", "Физика");
        controller.addTeacher("Наталья", "Иванова", "Физика");
        controller.addTeacher("Владимир", "Путин", "Химия");
        controller.addTeacher("Анжела", "Бушкова", "Химия");

        controller.addSchoolClass("5А", 1);
        controller.addSchoolClass("10В", 3);
        controller.addSchoolClass("7А", 5);

        controller.addStudent("Петр", "Насенков", "5А");
        controller.addStudent("Владислав", "Чунихин", "5А");
        controller.addStudent("Александр", "Степанов", "5А");
        controller.addStudent("Александр", "Михель", "5А");

        controller.addStudent("Дмитрий", "Денисов", "10В");
        controller.addStudent("Дмитрий", "Медведев", "10В");
        controller.addStudent("Денис", "Кальчинко", "10В");
        controller.addStudent("Татьяна", "Абдалова", "10В");

        controller.addStudent("Максим", "Хромов", "7А");
        controller.addStudent("Олег", "Мякинин", "7А");
        controller.addStudent("Станислав", "Бушков", "7А");
        controller.addStudent("Владислав", "Хромов", "7А");

        controller.addJournal(1, 1);
        controller.addJournal(2, 1);
        controller.addJournal(3, 1);
        controller.addJournal(1, 2);
        controller.addJournal(2, 2);
        controller.addJournal(3, 2);
        controller.addJournal(1, 3);
        controller.addJournal(2, 3);
        controller.addJournal(3, 3);

        controller.addMark(5, 5, 4, 2, 3, 1);
        controller.addMark(5, 5, 4, 2, 3, 1);
        controller.addMark(3, 7, 4, 1, 1, 2);
        controller.addMark(4, 7, 4, 2, 1, 2);
        controller.addMark(4, 7, 4, 1, 2, 3);
        controller.addMark(3, 7, 4, 3, 2, 3);
        controller.addMark(5, 2, 6, 10, 1, 2);
        controller.addMark(5, 2, 6, 11, 1, 2);
        controller.addMark(5, 2, 6, 12, 1, 2);
        controller.addMark(5, 2, 6, 4, 1, 2);
        controller.addMark(3, 14, 10, 5, 3, 1);
        controller.addMark(3, 14, 10, 5, 3, 1);
        controller.addMark(4, 28, 9, 6, 3, 3);
        controller.addMark(4, 28, 9, 6, 3, 3);
        controller.addMark(4, 29, 9, 7, 3, 3);
        controller.addMark(4, 29, 9, 7, 3, 3);
        controller.addMark(5, 13, 11, 8, 2, 1);
        controller.addMark(5, 13, 11, 8, 2, 1);
        controller.addMark(5, 13, 3, 9, 2, 1);
        controller.addMark(3, 13, 3, 9, 2, 2);
        controller.addMark(5, 13, 3, 9, 2, 1);
    }
}

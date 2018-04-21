package view;

import controller.Controller;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class View {
    private static Logger logger = Logger.getLogger(View.class.getSimpleName());
    private Controller controller;

    public View() {
        controller = new Controller();
    }

    public void startApp() {
        initialData();
        controller.saveData();
        controller.readData();
        boolean flag = true;
        while (flag) {
            menu();
            try (Scanner scanner = new Scanner(System.in)) {
                int selectAction = scanner.nextInt();
                switch (selectAction) {
                    case 1:
                        System.out.println("Введите ID школьного предмета, по которому хотите добавить журнал:");

                }
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
                "\n10 - Выход");
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

        controller.addSchoolClass("5A", 1);
        controller.addSchoolClass("10B", 3);
        controller.addSchoolClass("7A", 5);

        controller.addStudent("Петр", "Насенков", "5A");
        controller.addStudent("Владислав", "Чунихин", "5A");
        controller.addStudent("Александр", "Степанов", "5A");
        controller.addStudent("Александр", "Михель", "5A");

        controller.addStudent("Дмитрий", "Денисов", "10B");
        controller.addStudent("Дмитрий", "Медведев", "10B");
        controller.addStudent("Денис", "Кальчинко", "10B");
        controller.addStudent("Татьяна", "Абдалова", "10B");

        controller.addStudent("Максим", "Хромов", "7A");
        controller.addStudent("Олег", "Мякинин", "7A");
        controller.addStudent("Станислав", "Бушков", "7A");
        controller.addStudent("Владислав", "Хромов", "7A");

        controller.addJournal(1);
        controller.addJournal(2);
        controller.addJournal(3);

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

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

                }
            }
        }
    }

    private void menu() {
        System.out.println("Школьный журнал. Выберите действие:" +
                "\n1 - Создать журнал" +
                "\n2 - Получить журналы класса" +
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

    }
}

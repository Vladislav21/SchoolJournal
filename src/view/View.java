package view;

import controller.Controller;
import org.apache.log4j.Logger;

public class View {
    private static Logger logger = Logger.getLogger(View.class.getSimpleName());
    private Controller controller;

    public View() {
        controller = new Controller();
    }
}

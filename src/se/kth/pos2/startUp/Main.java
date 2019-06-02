package se.kth.pos2.startUp;

import se.kth.pos2.controller.Controller;
import se.kth.pos2.view.View;

/**
 * Class containing the main method.
 */
public class Main {
    /**
     * main method that creates an object of type controller and calls the view with this object as argument.
     * @param args for the main method.
     */
    public static void main(String[] args) {
        Controller contrl = new Controller();
        View view = new View(contrl);
        view.runFakeSale();
    }
}

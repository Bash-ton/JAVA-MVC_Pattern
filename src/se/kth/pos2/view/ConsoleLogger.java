package se.kth.pos2.view;

import se.kth.pos2.controller.Controller;

/**
 * implements the Logger interface to print an error message to the console.
 */
 class ConsoleLogger implements Logger {
     private final Controller contrl;

    /**
     * constructor that saves an instance of the controller.
     * @param contrl instans object of type controller.
     */
     ConsoleLogger(Controller contrl){
         this.contrl = contrl;
     }

    /**
     * overrides a method in the logger interface.
     * @param msg a string, a message that will be printed to the console.
     */
    @Override
    public void showErrorMsg(String msg){
        StringBuilder errorMsgBuilder = new StringBuilder();
        errorMsgBuilder.append(getTimeAndDate());
        errorMsgBuilder.append(", ERROR: ");
        errorMsgBuilder.append(msg);
        System.out.println(errorMsgBuilder);
    }
    private String getTimeAndDate(){
       return contrl.getCurrentTimeAndDate();
    }
}

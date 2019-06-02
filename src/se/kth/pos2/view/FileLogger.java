package se.kth.pos2.view;

import se.kth.pos2.controller.Controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * implmentation of the Logger interface. This class
 * creates a .text document storing the error message for developers.
 */
public class FileLogger implements Logger{
    private PrintWriter logStream;
    private final Controller contrl;

    /**
     * constructor that creates a .text document
     * @param contrl of type controller.
     */
    public FileLogger(Controller contrl){
        this.contrl = contrl;
        try{
            logStream = new PrintWriter(new FileWriter("devLog.text"),true);
        }catch (IOException ioe){
            System.out.println("Can not log exception in a text document for developers. ");
            ioe.printStackTrace();
        }
    }
    /**
     * Method that overrides a method in the interface Logger. Writes message to .text file.
     * @param msg of type String, a message that will get written on the devLog.text file.
     */
    @Override
    public void showErrorMsg(String msg){
        logStream.println(createTime());
        logStream.println(msg);
    }
    private String createTime(){
       return contrl.getCurrentTimeAndDate();
    }
}

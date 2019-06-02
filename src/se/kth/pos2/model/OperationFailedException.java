package se.kth.pos2.model;

/**
 * A general and wide checked exception that saves the cause of an exception and a message as a String.
 */
public class OperationFailedException extends Exception{
    public OperationFailedException(String msg,Exception cause){
        super(msg, cause);
    }
}
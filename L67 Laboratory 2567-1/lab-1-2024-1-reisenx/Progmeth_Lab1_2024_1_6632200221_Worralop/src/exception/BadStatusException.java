package exception;

public class BadStatusException extends Exception{
    public BadStatusException() {
        super("Status value can't less than 0");
    }
}

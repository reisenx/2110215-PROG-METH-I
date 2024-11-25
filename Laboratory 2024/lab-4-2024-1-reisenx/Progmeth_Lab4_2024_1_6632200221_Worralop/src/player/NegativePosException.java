package player;

public class NegativePosException extends Exception{

    public NegativePosException() {
        super("Player's position cannot be negative value");
    }
}

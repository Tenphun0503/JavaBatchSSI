package hw2.exceptionhandling;

public class CardTypeException extends RuntimeException{
    public CardTypeException() {
    }

    public CardTypeException(String message) {
        super(message);
    }
}

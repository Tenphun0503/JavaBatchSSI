package hw2.exceptionhandling;

public class AddressException extends RuntimeException {
    public AddressException(){
    }

    public AddressException(String message) {
        super(message);
    }
}

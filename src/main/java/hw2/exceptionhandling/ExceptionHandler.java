package hw2.exceptionhandling;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ExceptionHandler {
    private static final Set<String> ADDRESS = new HashSet<>(Arrays.asList("USA", "US"));

    private ExceptionHandler(){}

    public static void handleException(String cardType, String address){
        try{
            if ("AMEX".equals(cardType)) throw new CardTypeException();
            if (!ADDRESS.contains(address)) throw new AddressException();
        } catch (CardTypeException ce){
            System.out.println("Return CardTypeException");
        } catch (AddressException ae){
            System.out.println("Return AddressException");
        } catch (Exception e){
            System.out.println("Return GenericException");
        }
    }

    public static void main(String[] args) {
        handleException("VISA", "CN");
        handleException("AMEX", "USA");
    }
}

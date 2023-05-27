package hw2.java8.p1;

public interface CreditCard {
    String holderName = "";
    String cardNumber = "";
    Double accountBalance = 0.0;
    String cardType = "";

    boolean isCardAcceptable(String cardType);

    default void payBill(Double bill) {
        System.out.println("Payment of $" + bill + " processed.");
    }

    static void refund(double amount) {
        System.out.println("Refund of $" + amount + " processed.");
    }
}

class VisaCard implements CreditCard{
    String holderName;
    String cardNumber;
    Double accountBalance;
    String cardType;

    @Override
    public void payBill(Double bill) {
        accountBalance -= bill;
        CreditCard.super.payBill(bill);
    }

    public VisaCard(String holderName, String cardNumber, Double accountBalance, String cardType) {
        this.holderName = holderName;
        this.cardNumber = cardNumber;
        this.accountBalance = accountBalance;
        this.cardType = cardType;
    }

    @Override
    public boolean isCardAcceptable(String cardType) {
        return "Visa".equals(cardType);
    }
}

class MasterCard implements CreditCard{
    String holderName;
    String cardNumber;
    Double accountBalance;
    String cardType;

    @Override
    public void payBill(Double bill) {
        accountBalance -= bill;
        CreditCard.super.payBill(bill);
    }

    public MasterCard(String holderName, String cardNumber, Double accountBalance, String cardType) {
        this.holderName = holderName;
        this.cardNumber = cardNumber;
        this.accountBalance = accountBalance;
        this.cardType = cardType;
    }

    @Override
    public boolean isCardAcceptable(String cardType) {
        return "Master".equals(cardType);
    }
}

class Main {
    public static void main(String[] args) {
        VisaCard visaCard = new VisaCard("John Doe", "123456789", 1000.0, "Visa");
        MasterCard masterCard = new MasterCard("Jane Smith", "987654321", 2000.0, "MasterCard");

        visaCard.payBill(500.0);
        masterCard.payBill(1000.0);

        System.out.println("Visa Card Account Balance: $" + visaCard.accountBalance);
        System.out.println("MasterCard Account Balance: $" + masterCard.accountBalance);

        CreditCard.refund(100.0);
    }
}

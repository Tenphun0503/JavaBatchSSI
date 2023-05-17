package hw1.topic4.p2;

public abstract class CreditCard {
    protected String holderName;
    protected String cardNumber;
    protected double accountBalance;
    protected String cardType;

    public CreditCard(String holderName, String cardNumber, double accountBalance, String cardType) {
        this.holderName = holderName;
        this.cardNumber = cardNumber;
        this.accountBalance = accountBalance;
        this.cardType = cardType;
    }

    public abstract boolean isCardAcceptable(CreditCard card);

    public void payBill(double bill) {
        if (accountBalance >= bill) {
            accountBalance -= bill;
            System.out.println("Bill paid successfully.");
        } else {
            System.out.println("Insufficient funds. Payment failed.");
        }
    }
}

class VisaCard extends CreditCard{
    public VisaCard(String holderName, String cardNumber, double accountBalance) {
        super(holderName, cardNumber, accountBalance, "Visa");
    }

    @Override
    public boolean isCardAcceptable(CreditCard card) {
        return card.cardType.equals("Visa");
    }

    public static void main(String[] args) {
        VisaCard vc = new VisaCard("Jack", "4342 1451 2315 1174", 9999.99);
        System.out.println(vc.isCardAcceptable(vc));
        vc.payBill(10000);
    }

}

class MasterCard extends  CreditCard{
    public MasterCard(String holderName, String cardNumber, double accountBalance) {
        super(holderName, cardNumber, accountBalance, "Master");
    }

    @Override
    public boolean isCardAcceptable(CreditCard card) {
        return card.cardType.equals("Master");
    }
}
package hw1.topic5;

public class CurrencyExchange {
    public static Currency createCurrency(String countryName){
        Currency money;
        if("USA".equals(countryName)){
            money = new USD();
            money.print();
            return money;
        } else if ("China".equals(countryName)) {
            money = new CNY();
            money.print();
            return money;
        }
        return null;
    }
}

class Test{
    public static void main(String[] args) {
        Currency usa = CurrencyExchange.createCurrency("USA");
        System.out.println(usa.getClass());
    }
}

interface Currency{
    void print();
}

class USD implements Currency{
    @Override
    public void print() {
        System.out.println("This is USD");
    }
}

class CNY implements Currency{
    @Override
    public void print() {
        System.out.println("This is CNY");
    }
}
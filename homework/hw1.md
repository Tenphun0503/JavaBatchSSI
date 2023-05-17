# Core Java
## Topic: String
### Problems:
1. Given String `Algorithms`, return `go` and `Algo` using substring
    ```java
    class P1{
        public static void main(String[] args) {
            String str = "Algorithm";
            System.out.println(str.substring(2, 4));        // print: go
            System.out.println(str.substring(0, 4));        // print: Algo
        }
    }
    ```
2. Given two strings, compare if these two strings are equal by comparing each character
    ```java
    class P2{
        private static boolean ifEqual(String str1, String str2){
            if(str1.length() != str2.length()) return false;
            for (int i=0; i<str1.length(); i++){
                if(str1.charAt(i)!=str2.charAt(i)) return false;
            }
            return true;
        }
        public static void main(String[] args){
            String str1 = "abc";
            String str2 = "abd";
            String str3 = "abc";
            System.out.println(ifEqual(str1, str2));        // print: false
            System.out.println(ifEqual(str1, str3));        // print: true
        }
    }
    ```
3. Given string `http://www.amazon.com/demo?test=abc`, return `["https", "www", "amazon", "com", "demo", "test", "abc"]`
   ```java
   class P3{
      public static void main(String[] args) {
         String str1 = "https://www.amazon.com/demo?test=abc";
         System.out.println(Arrays.toString(str1.split("[:/.?=]+")));   // print: [https, www, amazon, com, demo, test, abc]
      }
   }
   ```
4. Given a list of string array, combine them into one string sentence, return the string sentence
   ```java
   class P4{
      public static void main(String[] args) {
         String[] strings = {"https", "www", "amazon", "com", "demo", "test", "abc"};
         StringBuilder sb = new StringBuilder();
         for (String s : strings) {
            sb.append(s).append(" ");
         }
         System.out.println(sb);    // print: https www amazon com demo test abc 
      }
   }
   ```


## Topic: Final
### Problems: 
Define a final class and final method and final variable, modify the value of the variable in final method
```java
// Final Classes cannot be inherited
public final class FinalTopic {

    // Final variables must be initialized either during declaration or within the constructor.
    // Final variables cannot be modified once assigned.
    private static final ArrayList<Integer> VAR = new ArrayList<>();

    // Final methods cannot be overridden in th subclasses
    private static final void method(){
        VAR.add(1);
        VAR.add(2);
    }

    public static void main(String[] args) {
        method();
        System.out.println(VAR);        // print: [1, 2]
    }
}
```

## Topic: Static
### Problems:
1. Given a database table `Book` with columns (id, isbn, name, author, publish data), define a java
class that matched this table and then use a static block to initialize this table with some records
   ```java
   class Book {
      private int id;
      private String isbn;
      private String name;
      private String author;
      private LocalDate publishDate;
   
      public Book(int id, String isbn, String name, String author, LocalDate publishDate) {
         this.id = id;
         this.isbn = isbn;
         this.name = name;
         this.author = author;
         this.publishDate = publishDate;
      }
   
      private static final List<Book> books;
   
      static {
         books = new ArrayList<>();
         books.add(new Book(1, "9780544003415", "The Hobbit", "J.R.R. Tolkien", LocalDate.of(1937, 9, 21)));
         books.add(new Book(2, "9780439554930", "Harry Potter and the Sorcerer's Stone", "J.K. Rowling", LocalDate.of(1997, 6, 26)));
         books.add(new Book(3, "9780061120084", "To Kill a Mockingbird", "Harper Lee", LocalDate.of(1960, 7, 11)));
      }
   }
   ```
2. Define a Java class `BookSeller` and then define a static inner class `Book`, and use static method
`sellBooks()` to initialize several books, and in the main method display all the books by calling the 
`sellBooks()` method
   ```java
   class BookSeller{
       static class Book{
           private int id;
           private String isbn;
           private String name;
           private String author;
           private LocalDate publishDate;
   
           public Book(int id, String isbn, String name, String author, LocalDate publishDate) {
               this.id = id;
               this.isbn = isbn;
               this.name = name;
               this.author = author;
               this.publishDate = publishDate;
           }
           
           @Override
           public String toString() {
               return "Book{" +
                       "id=" + id +
                       ", isbn='" + isbn + '\'' +
                       ", name='" + name + '\'' +
                       ", author='" + author + '\'' +
                       ", publishDate=" + publishDate +
                       '}';
           }
       }
       private static final List<Book> books = new ArrayList<>();
       private static List<Book> sellBooks(){
           books.add(new Book(1, "9780544003415", "The Hobbit", "J.R.R. Tolkien", LocalDate.of(1937, 9, 21)));
           books.add(new Book(2, "9780439554930", "Harry Potter and the Sorcerer's Stone", "J.K. Rowling", LocalDate.of(1997, 6, 26)));
           books.add(new Book(3, "9780061120084", "To Kill a Mockingbird", "Harper Lee", LocalDate.of(1960, 7, 11)));
           return books;
       }
   
       public static void main(String[] args) {
           System.out.println(sellBooks());
       }
   }
   ```

## Topic: OOP
### Problems:
1. Define an interface `DatabaseConnection` and then define class `OracleConnection`, `MySqlConnecteion`, `SqlServerConnection`.
They should all implement the `getConnection()` from the interface. The method should initialize data source and return a database connection
   ```java
   public interface DatabaseConnection {
       String getConnection();
   }
   
   class OracleConnection implements DatabaseConnection{
       @Override
       public String getConnection() {
           // simulate Oracle connection initialization
           return "OracleConnection";
       }
   }
   class MySqlConnection implements DatabaseConnection{
       @Override
       public String getConnection() {
           // simulate MySql connection initialization
           return "MySqlConnection";
       }
   }
   class SqlServerConnection implements DatabaseConnection{
       @Override
       public String getConnection() {
           // simulate SqlServer connection initialization
           return "SqlServerConnection";
       }
   }
   ```
2. Define an abstract class `CreditCard` which contains fields (holderName, cardNumber, accountBalance, cardType), 
and not-implemented method `isCardAcceptable()` with argument cardType, and implemented method `payBill(double bill)`.
Define two classes `VisaCard` and `MasterCard` both should inherit this `CreditCard` class and you should define constructor
for both classes and implement the `isCardAcceptable()` method.
```java
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
```
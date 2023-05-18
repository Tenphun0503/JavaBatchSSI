# Core Java

---
## Topic: String
### Problems:
[StringTopic.java](../src/main/java/hw1/topic1/StringTopic.java)
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
         System.out.println(Arrays.toString(str1.split("[^a-z]+")));   // print: [https, www, amazon, com, demo, test, abc]
      }
   }
   ```
4. Given a list of string array, combine them into one string sentence, return the string sentence
   ```java
   class P4{
      public static void main(String[] args) {
        List<String[]> list = new ArrayList<>();
        String[] s1 = {"https", "www", "amazon", "com", "demo", "test", "abc"};
        String[] s2 = {"Hello", "World"};
        list.add(s1);
        list.add(s2);
        StringBuilder sb = new StringBuilder();
        for (String[] s : list) {
            for (String word : s) {
                sb.append(word).append(" ");
            }
        }
        System.out.println(sb.toString().trim());   // print: https www amazon com demo test abc Hello World
      }
   }
   ```

## Topic: Final
### Problems: 
[FinalTopic.java](../src/main/java/hw1/topic2/FinalTopic.java)  
1. Define a final class and final method and final variable, modify the value of the variable in final method
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
1. Given a database table **Book** with columns (id, isbn, name, author, publish data), define a java
class that matched this table and then use a static block to initialize this table with some records  
[Book.java](../src/main/java/hw1/topic3/Book.java)
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
   
      private static final List<Book> books = new ArrayList<>();
   
      static {
         books.add(new Book(1, "9780544003415", "The Hobbit", "J.R.R. Tolkien", LocalDate.of(1937, 9, 21)));
         books.add(new Book(2, "9780439554930", "Harry Potter and the Sorcerer's Stone", "J.K. Rowling", LocalDate.of(1997, 6, 26)));
         books.add(new Book(3, "9780061120084", "To Kill a Mockingbird", "Harper Lee", LocalDate.of(1960, 7, 11)));
      }
   }
   ```
2. Define a Java class **BookSeller** and then define a static inner class **Book**, and use static method
`sellBooks()` to initialize several books, and in the main method display all the books by calling the 
`sellBooks()` method  
[BookSeller.java](../src/main/java/hw1/topic3/BookSeller.java)
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
[DatabaseConnection.java](../src/main/java/hw1/topic4/p1/DatabaseConnection.java)  
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
Define two classes `VisaCard and MasterCard` both should inherit this `CreditCard` class, and you should define constructor
for both classes and implement the `isCardAcceptable()` method.  
[CreditCard.java](../src/main/java/hw1/topic4/p2/CreditCard.java)
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
3. Implement static and dynamic polymorphism.  
[Animal.java](../src/main/java/hw1/topic4/Animal.java)
   ```java
   public class Animal {
       private String name;
       public Animal(String name){
           this.name = name;
           System.out.println("Create an animal, called " + this.name);
       }
   
       public void eat(String food){
           System.out.println(name + " ate " + food);
       }
   
       // Overload
       public void eat(String f1, String f2){
           System.out.println(name + " ate " + f1 + " and " + f2);
       }
   }
   
   class Cat extends Animal {
       public Cat(String name){
           super(name);
           System.out.println("It's a cat");
       }
   
       @Override
       public void eat(String food) {
           System.out.println("Cat ate " + food);
       }
   }
   
   class Test{
       public static void main(String[] args) {
           Animal animal = new Animal("momo");      // Create an animal, called momo
           animal.eat("fish");                      // momo ate fish
           animal.eat("fish", "chicken");           // momo ate fish and chicken
           Cat cat = new Cat("lena");               // Create an animal, called lena \n It's a cat
           cat.eat("fish");                         // Cat ate fish
       }
   }
   ```

## Topic: Design Pattern
### Problems
1. Create a singleton class called “AppleDesignerFactory”  
[AppleDesignerFactory.java](../src/main/java/hw1/topic5/AppleDesignerFactory.java)
   ```java
   public class AppleDesignerFactory implements Serializable, Cloneable {
       private static AppleDesignerFactory instance;
   
       // private constructor
       private AppleDesignerFactory(){}
   
       // static synchronized getInstance() method
       public static synchronized AppleDesignerFactory getInstance(){
           if (instance == null) instance = new AppleDesignerFactory();
           return instance;
       }
   
       // prevent clone
       @Override
       protected Object clone() throws CloneNotSupportedException {
           throw new CloneNotSupportedException();
       }
   
       // prevent Serializable/Deserializable
       protected Object readResolve(){
           return instance;
       }
   }
   ```
2. Create a factory pattern called “CurrencyExchange” which takes in the country name and return the currency object for that country.  
[CurrencyExchange.java](../src/main/java/hw1/topic5/CurrencyExchange.java)
   ```java
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
   ```
3. Implement the (in-class) PARKING LOT OOP design system -> your implementation should include main method and is runnable.  
[ParkingLot.java](../src/main/java/hw1/topic5/ParkingLot.java)  
Run `Main` to show test result.
   ```java
   package hw1.topic5;
   
   import java.util.ArrayList;
   import java.util.List;
   
   class Vehicle{
       private final String plateNumber;
   
       public Vehicle(String plateNumber) {
           this.plateNumber = plateNumber;
       }
   
       @Override
       public String toString() {
           return "Vehicle{" +
                   "plateNumber='" + plateNumber + '\'' +
                   '}';
       }
   }
   
   public class ParkingLot {
       private final int capacity;
   
       private final List<Vehicle> carList;
   
       public ParkingLot(int capacity) {
           this.capacity = capacity;
           this.carList = new ArrayList<>();
       }
   
       // parking
       public void park(Vehicle car){
           if(carList.size() >= capacity){
               System.out.println("Parking lot is full");
           }else{
               carList.add(car);
               System.out.println(car + " parked");
           }
       }
   
       // un-parking
       public void unPark(Vehicle car){
           if(!carList.contains(car)){
               System.out.println(car + " isn't in the parking lot");
           }else{
               carList.remove(car);
               System.out.println(car + " leaved");
           }
       }
   
       // list parked cars
       public void listCars(){
           System.out.println(carList);
       }
   
   }
   
   class Main{
       public static void main(String[] args) {
           // create a parking lot with size of 3
           ParkingLot pkl = new ParkingLot(3);
   
           // create some cars
           Vehicle car1 = new Vehicle("ABC123");    
           Vehicle car2 = new Vehicle("XYZ789");    
           Vehicle car3 = new Vehicle("DEF456");    
           Vehicle car4 = new Vehicle("GHI789");    
   
           // park the cars
           pkl.park(car1);              // Vehicle{plateNumber='ABC123'} parked
           pkl.park(car2);              // Vehicle{plateNumber='XYZ789'} parked
           pkl.park(car3);              // Vehicle{plateNumber='DEF456'} parked
           pkl.park(car4);              // Parking lot is full
   
           // print the car list
           pkl.listCars();  
   
           // unPark the car
           pkl.unPark(car2);            // Vehicle{plateNumber='XYZ789'} leaved
   
           pkl.unPark(car4);            // Vehicle{plateNumber='GHI789'} isn't in the parking lot
           pkl.park(car4);              // Vehicle{plateNumber='GHI789'} parked
   
           // print the car list        
           pkl.listCars();
       }
   }
   ```

## Topic: Collection
### Problems:
1. (Set)Find true friends: Given two arraylists containing friend names, find the true friends that appear in both list.  
[FindTrueFriends.java](../src/main/java/hw1/topic6/FindTrueFriends.java)
   ```java
   public class FindTrueFriends {
       public static void main(String[] args) {
           List<String> names1 = new ArrayList<>();
           List<String> names2 = new ArrayList<>();
   
           // Adding names to names1
           names1.add("John");
           names1.add("Alice");
           names1.add("Bob");
           names1.add("Eve");
   
           // Adding names to names2
           names2.add("Bob");
           names2.add("Eve");
           names2.add("Michael");
           names2.add("Alice");
   
           // Create a Set
           HashSet<String> nameSet = new HashSet<>(names1);
           List<String> trueFriends = new ArrayList<>();
           for(String name: names2){
               if(nameSet.contains(name)) trueFriends.add(name);
           }
           System.out.println(trueFriends);             // [Bob, Eve, Alice]
       }
   }
   ```
2. (Map)Given a string, output duplicate characters and their counts  
[CountDuplicates](../src/main/java/hw1/topic6/CountDuplicates.java)
   ```java
   public class CountDuplicates {
       public static void main(String[] args) {
   
           String str = "Hello World";
           Map<Character, Integer> map = new HashMap<>();
           for (char c : str.toCharArray()) {
               if(!Character.isLetter(c)||Character.isWhitespace(c)) continue;
   
               map.put(c, map.getOrDefault(c, 0) + 1);
           }
           for (Map.Entry<Character, Integer> e : map.entrySet()){
               if (e.getValue()>1){
                   System.out.println(e.getKey() + " : " + e.getValue());   // l : 3 \n o : 2
               }
           }
       }
   }
   ```
3. Use a map to simulate database table, key should be the primary key (assume only one column), value is the record, your simulation should include CRUD operation methods  
[SimulateTable](../src/main/java/hw1/topic6/SimulateTable.java)
   ```java
   public class SimulateTable<K, V> {
       private final Map<K, V> map;
   
       public SimulateTable() {
           map = new HashMap<>();
       }
   
       public void add(K key, V value){
           if(map.containsKey(key)){
               System.out.println("Primary Key existed: " + key);
           }else {
               map.put(key, value);
               System.out.println("Record added successfully.");
           }
       }
   
       public void update(K key, V value){
           if(!map.containsKey(key)){
               System.out.println("Key does not exist");
           }else{
               map.put(key, value);
               System.out.println("Record updated successfully.");
           }
       }
   
       public Map<K,V> select(){
           return map;
       }
   
       public Map.Entry<K,V> select(K id){
           return Map.entry(id, map.get(id));
       }
   
       public void delete(K id){
           if(!map.containsKey(id)){
               System.out.println("Key does not exist");
               return;
           }
           map.remove(id);
           System.out.println("Successfully removed data");
       }
   
   
       public static void main(String[] args) {
           // Create a table
           SimulateTable<Integer, String> bookTable = new SimulateTable<>();
           // insert into book_table(id, value) values (k, v);
           bookTable.add(1, "Math");                                // Record added successfully.
           bookTable.add(2, "English");                             // Record added successfully.
           bookTable.add(3, "Chinese");                             // Record added successfully.
           // primary key should be unique
           bookTable.add(1, "Science");                             // Primary Key existed: 1                  
           // select * from book_table;
           System.out.println(bookTable.select());                  // {1=Math, 2=English, 3=Chinese}               
           // select * from book_table where id=2;
           System.out.println(bookTable.select(2));                 // 2=English
           // update book_table set value='Biology' where id=3;
           bookTable.update(3, "Biology");                          // Record updated successfully.         
           // delete from book_table where id=2;
           bookTable.delete(2);                                     // Successfully removed data
           // key not exist
           bookTable.delete(2);                                     // Key does not exist                          
           // select * from book_table;
           System.out.println(bookTable.select());                  // {1=Math, 3=Biology}      
       }
   }
   ```
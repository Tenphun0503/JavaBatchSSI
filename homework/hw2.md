# Core Java

---
## Topic: Serializable
### Problems: 
1. Define a “[Employee](../src/main/java/hw2/serializable/Employee.java)” POJO class and make it serializable
    ```java
    public class Employee implements Serializable {
        @Serial
        private static final long serialVersionUID = 1234L;
   
        private int id;
        private String name;
        private int age;
    
        public Employee() {
        }
    
        public Employee(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }
    
        public int getId() {
            return id;
        }
    
        public void setId(int id) {
            this.id = id;
        }
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public int getAge() {
            return age;
        }
    
        public void setAge(int age) {
            this.age = age;
        }
    }
    ```

## Topic: Exception Handling
### Problems:
1. Define two exceptions “[CardTypeException](../src/main/java/hw2/exceptionhandling/CardTypeException.java)” and “[AddressException](../src/main/java/hw2/exceptionhandling/AddressException.java)”. 
Create a separate class “[ExceptionHandler](../src/main/java/hw2/exceptionhandling/ExceptionHandler.java)” which contains one method “handleException”. 
The method takes input of cardType and address. If cardType is `AMEX`, throw `CardTypeException`. 
If address is outside `US`, return `AddressException`, for other errors, just return `GenericException`. 
Your exception should be caught, and you should display message to tell which exception is returned.
   ```java
   public class AddressException extends RuntimeException {
       public AddressException(){
       }
   
       public AddressException(String message) {
           super(message);
       }
   }
   
   public class CardTypeException extends RuntimeException{
      public CardTypeException() {
      }
   
      public CardTypeException(String message) {
         super(message);
      }
   }
   ```
   ```java
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
           handleException("VISA", "CN");          // Return AddressException
           handleException("AMEX", "USA");         // Return CardTypeException
       }
   }
   ```

## Topic: ExecutorService
### Problems:
1. Define an inner class A has method `getMethod()` which return string `A.getMethod`
and another inner class B has method `getMethod()` which return string `B.getMethod`.
Write another method [**runSameTime( )**](../src/main/java/hw2/executorservice/ExecutorServiceSample.java) which should let A and B getMethod to run at the same time, 
but the `runSameTime()` method should return a string `B.getMethod A.getMethod`
   ```java
   public class ExecutorServiceSample {
       static class A {
           static String getMethod(){
               return "A.getMethod";
           }
       }
       static class B {
           static String getMethod(){
               return "B.getMethod";
           }
       }
   
       public static String runSameTime(){
           ExecutorService service = Executors.newFixedThreadPool(2);
   
           Future<String> futureA = service.submit(A::getMethod);
           Future<String> futureB = service.submit(B::getMethod);
           try {
               String resultA = futureA.get();
               String resultB = futureB.get();
   
               return resultB + " " + resultA;
           } catch (Exception e) {
               e.printStackTrace();
               return null;
           } finally {
               service.shutdown();
           }
       }
   
       public static void main(String[] args) {
           System.out.println(runSameTime());
       }
   }
   ```


## Topic: Java 8
### Problems:
1. Define an interface “CreditCard” which contains fields (holderName, cardNumber, accountBalance, cardType), 
and not-implemented method “isCardAcceptable” with argument cardType. 
Define two classes “VisaCard” and “MasterCard” both should inherit this “CreditCard” interface, 
and you should define constructor for both classes and implement the “isCardAcceptable” method. 
Now Add a default method “payBill(double bill)” and static method “refund(double amount)” to the interface. 
Verify that VisaCard and MasterCard class can read these two methods (use Main method to verify).
Use functional interface to implement Java 8 stream.map() function. 

2. Define a “MyStream” class containing a functional interface and a static method “MyMap”.
In main method, test your code by calling: MyStream.MyMap(list, o -> o *3) to multiple each element in the “list” by 3.
"walabcwalexywalxzsfwalmx”  -- replace "wal" with "sams"
"Eclipse eclipse Eclipse eclipse amc clip ECLIPSE" – count the occurrence of each unique word (ignore case), 
return result as a map. For example (eclipse->5, amc->1, clip->1)


 

package hw1.topic6;

import java.util.HashMap;
import java.util.Map;

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
            System.out.println("Key not exist");
            return;
        }
        map.remove(id);
        System.out.println("Successfully removed data");
    }


    public static void main(String[] args) {
        // Create a table
        SimulateTable<Integer, String> bookTable = new SimulateTable<>();
        // Add data
        bookTable.add(1, "Math");                       // insert into book_table(id, value) values (1, 'Math');
        bookTable.add(2, "English");
        bookTable.add(3, "Chinese");
        bookTable.add(1, "Science");                    // primary key should be unique
        // Query table
        System.out.println(bookTable.select());         // select * from book_table;
        System.out.println(bookTable.select(2));    // select * from book_table where id=2;
        // Update data
        bookTable.update(3, "Biology");                 // update book_table set value='Biology' where id=3;
        // Delete data
        bookTable.delete(2);                        // delete from book_table where id=2;
        bookTable.delete(2);                        // key not exist
        // Query table
        System.out.println(bookTable.select());         // select * from book_table;
    }
}

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
        pkl.park(car1);
        pkl.park(car2);
        pkl.park(car3);
        pkl.park(car4);

        // print the car list
        pkl.listCars();

        // unpark the car
        pkl.unPark(car2);

        pkl.unPark(car4);
        pkl.park(car4);

        // print the car list
        pkl.listCars();
    }
}

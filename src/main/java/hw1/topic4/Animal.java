package hw1.topic4;

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
        Animal animal = new Animal("momo");
        animal.eat("fish");
        animal.eat("fish", "chicken");
        Cat cat = new Cat("lena");
        cat.eat("fish");
    }
}

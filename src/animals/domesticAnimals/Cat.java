package animals.domesticAnimals;

import animals.Animal;

public class Cat extends DomesticAnimal {
    public Cat(String aName) {
        super(aName);
    }

    @Override
    public void say() {
//        super.say(); // if keeping the parent's method is required
        System.out.println("I am saying maiu!");

    }

    public static void main(String[] args) {

        Cat cat = new Cat("Murka");
        cat.say();
        cat.livingWithPeople();

        Dog dog = new Dog("Richy");
        dog.say();
        dog.livingWithPeople();

        // Polymorphism of the inheritance: creating objects via making use of the one parent Class
        Animal animal1 = new Cat("animal - cat");
        animal1.say();

        Animal animal2 = new Dog("animal - dog");
        animal2.say();

    }


}

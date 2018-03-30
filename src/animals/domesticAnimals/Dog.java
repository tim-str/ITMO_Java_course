package animals.domesticAnimals;

public class Dog extends DomesticAnimal {

    public Dog(String aName) {
        super(aName);
    }

    // the override is mandatory to invoke the child specific method;
    // the COMP wil flag you if there is no parent method existing
    @Override
    public void say() {
//        super.say(); // if keeping the parent's method is required
        System.out.println("I am barking!");
    }

//    public static void main(String[] args) {
//        Dog dog = new Dog("Richy");
//        dog.say();
//        dog.livingWithPeople();
//    }

}

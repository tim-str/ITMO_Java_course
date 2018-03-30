package animals;

public class Animal {

    public String name;

    public Animal(String aName) {
        this.name = aName;
    }

    public void say() {
        System.out.println("say something!");
    }

    private String surname;     // if a method being used only within the class is to be defined as "private"
                                // for sure - the incapsulation

    private void privateVoid() {
        System.out.println("privateVoid");
        protectedVoid();
    }

    protected void protectedVoid() {
        System.out.println("protectedVoid");
    }

// access modifiers:
// "public" is visible from everywhere;
// "protected" - from within the package where the class sits and to subclass from any package;
// "private"   - only within the class;
// "default", i.e.  without a modifier - within the class.


}

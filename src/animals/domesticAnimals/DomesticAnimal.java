package animals.domesticAnimals;

import animals.*;
import com.sun.xml.internal.org.jvnet.fastinfoset.sax.FastInfosetReader;

public class DomesticAnimal extends Animal {    // the child-class inherits all public methods
    public DomesticAnimal (String aName) {
        super(aName);
    }

    public void livingWithPeople() {
        System.out.println("I can live with my host");
        super.protectedVoid();
    }

//    public static void  main(String[] args) {
//
//        DomesticAnimal da = new DomesticAnimal("DomAnimal");
//
//        da.say();
//        da.livingWithPeople();
//        da.name = "new name";
//
//    }

}

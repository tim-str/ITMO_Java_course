package animals;

import javax.swing.plaf.synth.SynthTextAreaUI;

public class Animal {

    public String name;

    public Animal(String aName) {
        this.name = aName;
    }

    public void say() {
        System.out.println("say something!");
    }

}

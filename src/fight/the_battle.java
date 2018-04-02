package fight;

import java.util.Random;

public class the_battle {
    public static void fight(Soldier[] aWhiteArmy, Soldier[] aRedArmy) {

        Random rnd = new Random();

        for(int i = 0; i < 10; i++) {
            if (rnd.nextBoolean()) {
                aWhiteArmy[i].attack(aRedArmy[i]);
            } else {
                aRedArmy[i].attack(aWhiteArmy[i]);
            }
        }
    }

    public static void winner(Soldier[] aWhiteArmy, Soldier[] aRedArmy){
        int whiteAlive = 0;
        int redAlive = 0;

        for(int i=0; i < 10; i++) {
            if (aRedArmy[i].isAlive()) {
                redAlive++;
            }
            if (aWhiteArmy[i].isAlive()) {
                whiteAlive++;
            }
        }

        System.out.println("whiteAlive " + whiteAlive + " redAlive " + redAlive);

    }

    public static void main(String[] args) {

        Soldier[] whites = new Soldier[10];
        Soldier[] reds = new Soldier[10];

        for(int i=0; i < whites.length; i++) {
            whites[i] = new White();
            reds[i] = new Red();
        }

        fight(whites, reds);
        winner(whites, reds);

    }
}

// reading data from a cfg where data is in key-value format
// to propose a structure of reading data from .cfg

// методы класса Jbject
// операторы final / static
// фнонимные и вложенные классы

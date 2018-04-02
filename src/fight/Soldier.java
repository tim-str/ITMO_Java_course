package fight;

//abstract class Soldier {
//
//    protected int health;
//    protected int attackScore;
//
//    public Soldier() {
//
//    }
//
//}

abstract class Soldier {
    int health;
    int attackScore;

    public Soldier(int health, int attackScore) {
        this.health = health;
        this.attackScore = attackScore;
    }

    public  Boolean isAlive() {
        return health > 0;
    }

    abstract void attack(Soldier enemy);        // we have decided to get rid of the implementation of the method
                                                // in the Soldier class as the implementation is different
}

class Red extends Soldier {

//    int someInt;

    public Red() {
        super(60,100);     // calling out the parent class' constructor and this is to be called first
//        this.someInt = 3;
    }

    @Override
    public void attack(Soldier enemy) {
        enemy.health -= attackScore + 10;
    }

}

class White extends Soldier {

//    int someInt;

    public White() {
        super(80,50);     // calling out the parent class' constructor and this is to be called first
//        this.someInt = 3;
    }

    @Override
    public void attack(Soldier enemy) {
        enemy.health -= attackScore + 20;
    }

}


//
//class Red {
//
//    int health;
//    int attackScore;
//
//    public Red(int health, int attackScore) {
//        this.health = health;
//        this.attackScore = attackScore;
//    }
//
//    public  Boolean isAlive() {
//        return health > 0;
//    }
//
//    public void attack(White white) {
//        white.health -= attackScore;
//    }
//}
//
//class White {
//
//    int health;
//    int attackScore;
//
//    public White(int health, int attackScore) {
//        this.health = health;
//        this.attackScore = attackScore;
//    }
//
//    public  Boolean isAlive() {
//        return health > 0;
//    }
//
//    public void attack(Red red) {
//        red.health -= attackScore;
//    }
//
//}



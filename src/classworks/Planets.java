package classworks;

import static classworks.Planet.getFeatures;
import static classworks.Planets.ListofPlanets.*;

public class Planets {

    enum ListofPlanets {Mercury, Venus, Earth, Mars, Jupiter, Saturn, Uranus, Neptune}

    public static void main(String[] args) {

        Planet planet_1 = new Planet(Mercury);
        getFeatures(planet_1);

        Planet planet_2 = new Planet(Venus);
        getFeatures(planet_2);

    }
}

class Planet {
//    private static Planets.ListofPlanets list;
    private Planets.ListofPlanets name;
    private double mass;
    private double radius;

    Planet (Planets.ListofPlanets name) {
        switch (name)
        {
            case Mercury: {
            this.name = name;
            this.mass = 3.303e+23;
            this.radius = 2439.7;
            break;
            }
            case Venus: {
                this.name = name;
                this.mass = 4.869e+24;
                this.radius = 6051.8;
                break;
            }
            case Earth: {
                this.name = name;
                this.mass = 5.976e+24;
                this.radius = 6378.1;
                break;
            }
            default: System.out.println("Please enter a correct planet name");
        }
    }

    protected static void getFeatures(Planet planet) {
        System.out.println("For " + planet.name + " the mass is " + planet.mass + "kg. and the radius is " + planet.radius + "km.");
    }
}

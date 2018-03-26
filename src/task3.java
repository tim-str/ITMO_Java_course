import java.lang.Math;

public class task3 {
    public static void main(String[] args) {

        int challenge = 666; /* the input value */

        int dec2 = challenge%1000/100;
        int dec1 = challenge%100/10;
        int dec0 = challenge%10;

        System.out.println(dec2 + " " + dec1 + " " + dec0);

        System.out.println("The max of decimal place multipliers is " + Math.max(Math.max(dec2,dec1),Math.max(dec1,dec0)));

    }
}

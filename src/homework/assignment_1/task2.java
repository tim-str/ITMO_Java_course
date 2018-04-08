package homework.assignment_1;

import static com.sun.org.apache.xalan.internal.lib.ExsltMath.*;

public class task2 {
    public static void main(String[] args) {
        double a, b, c;

        a = 1.0;
        b = 5.0;
        c = 1.0;

        double D = power(b,2) -4*a*c;
        System.out.println(D);

        if (D < 0) {
            System.out.println("Cannot be resolved in R. The roots are of the complex number type.");
        } else if (D==0) {
            System.out.println("The only solution is x1 = " + (-b+sqrt(D))/2*a);
        } else
        {
            System.out.println("The equation being resolved with two roots:");
            System.out.println("x1 = " + ((-b+sqrt(D))/2*a));
            System.out.println("x2 = " + ((-b-sqrt(D))/2*a));
        }
    }
}

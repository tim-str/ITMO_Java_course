import java.lang.Math;

public class assignment_1_the_tram {

    public static void main(String[] args) {

        int count =0;
        int dec6, dec5, dec4, dec3, dec2, dec1;

        for (int ticketNumber = 100000; ticketNumber <= 999999; ticketNumber++) {

            dec6 = ticketNumber % 1000000 / 100000;
            dec5 = ticketNumber % 100000 / 10000;
            dec4 = ticketNumber % 10000 / 1000;
            dec3 = ticketNumber % 1000 / 100;
            dec2 = ticketNumber % 100 / 10;
            dec1 = ticketNumber % 10;

            if ((dec6+dec5+dec4)==(dec3+dec2+dec1)) {

                count=count+1;
//                if (count>100 && count<=105) {System.out.println(ticketNumber);}
            }

        }

        System.out.println("Number of the lucky tickets calculated: " + count);
    }
}

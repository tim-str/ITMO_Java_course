public class task9 {

    public static void main(String[] args) {

        String str = "String"; // the object is immutable; the most common way of creating a string //
        String str1 = "String"; // str & str1 - are links to the same object //

        String srt1 = "New";

        System.out.println(str==str1);

        String str2 = new String("String 2");
        String str3 = new String("String 2"); // str2 & str3 - are different objects //

        System.out.println(str2==str3);

        String st = String.format("a template with symbols %d%n", 3434); // the formatting slows down performance //
        System.out.println(st);

        StringBuilder sb = new StringBuilder("Hello"); // the object created is mutable //
        StringBuffer sf = new StringBuffer("concurrency " + "will be reviewed later on"); // the object created is mutable. more suitable for working with concurrent processing //

        // System.out.println(sf);

        sb.append("!");

        System.out.println(sb);

        sb.append("!").append("!!");
        System.out.println(sb);

        sb.insert(3,"some new").append("new");
        System.out.println(sb);

        String stFromLoop = "";
        for (int i=0; i<10; i++) {
            stFromLoop += "number:" + i + " ";

        }
        System.out.println(stFromLoop);

        // J:\My stuff\Java course\out\production\Java course>javap -c task9

        long start = System.nanoTime();

        StringBuilder sbLoop = new StringBuilder();
        String stFromLoop1 = "";
        for (int i=0; i<10; i++) {
            sbLoop.append("number: ").append(i);
            // stFromLoop1 += "number: " + i;
        }

        long end = System.nanoTime();

        System.out.println("Time: " + (-start+end)/1000000.0 + "msec");

        // System.out.println(sbLoop);
        System.out.println(stFromLoop.equals(stFromLoop1)); // comparing strings
        System.out.println(stFromLoop.compareTo(stFromLoop1)); // comparing strings
        System.out.println(stFromLoop.compareToIgnoreCase(stFromLoop1)); // comparing strings
        System.out.println(stFromLoop.equalsIgnoreCase(stFromLoop1)); // comparing strings
        // 0 - if the argument is lexically equal to the string stFromLoop;
        // < 0 - if str2 > str1
        // > 0 - if str1 > str2

        int strLength = sbLoop.length();
        System.out.println(strLength);

        // Builder & Buffer objects have to be converted to the String type using "ToString" method

    }
}

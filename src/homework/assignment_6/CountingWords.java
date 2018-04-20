package homework.assignment_6;

import com.horstmann.corejava.Employee;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class CountingWords {

    public static void getTop10(Map<String, Integer> hashMap) {
        for(Map.Entry e : hashMap.entrySet()) {

        }

    }

    public static HashMap getGroupedWords(HashMap hashMap, boolean exclusions) {

        return null;
    }

    public static void getFreqLetters(HashMap hashMap) {

    }

    public static void main(String[] args) {

        Map<String, Integer> wordsMap = new HashMap<>();

        try {

            File inFile = new File("src/homework/assignment_6/wp_10.txt");
            List lst = Files.readAllLines(inFile.toPath());
//            System.out.println(lst);
            Iterator<String> iterator = lst.iterator();

            while (iterator.hasNext()) {

                String[] inString = iterator.next().split(" ");

                String[] outString = inString;

                for (int i = 0; i < inString.length; i++) {
                    if (!inString[i].isEmpty()) {
                        outString[i] = inString[i].replaceAll("[^A-Za-z]", "");
                    }
                }
//                for (int i = 0; i < outString.length; i++) System.out.println("i = " + i + outString[i]);

                for (String str : outString) {
                    if (!str.isEmpty()) {
                        if (wordsMap.containsKey(str.toUpperCase())) {
                            wordsMap.put(str.toUpperCase(), wordsMap.get(str.toUpperCase()) + 1); }
                            else wordsMap.put(str.toUpperCase(), 1);
                    }
                }
            }
        }

        catch (IOException e) {

        }
        finally {
            wordsMap.forEach((k, v) ->
                    System.out.println("key=" + k + ", value=" + v));
        }

        Map<String, Integer> top10Map = new HashMap<>();

        for(int i = 1; i <= 10; i++) {
            Integer j = 0;
            String key = null;
            for (Map.Entry entry : wordsMap.entrySet()) {
                if ( (Integer) entry.getValue() > j) {
                    // System.out.println("control point");
                    j = (Integer) entry.getValue();
                    key = (String) entry.getKey();
                }
            }

            if (!top10Map.containsKey(key)) top10Map.put(key,j);
            wordsMap.remove(key, j);
        }

        System.out.println("Top10 list:");
        top10Map.forEach((k, v) ->
                System.out.println("key=" + k + ", value=" + v));

    }
}

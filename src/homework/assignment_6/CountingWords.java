package homework.assignment_6;

import com.horstmann.corejava.Employee;
import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Array;
import java.util.*;
import java.util.regex.Pattern;

import static homework.assignment_6.Metrics.writeOutInMap;

public class CountingWords {

    public static void main(String[] args) {

        Map<String, Integer> wordsMap = new HashMap<>();
        List lst = null;

        try {

            File inFile = new File("src/homework/assignment_6/wp.txt");
            lst = Files.readAllLines(inFile.toPath());
        }

        catch (Exception e) {
            System.out.println(e.getMessage());
        }

            Iterator<String> iterator = lst.iterator();

            while (iterator.hasNext()) {

                String[] inString = iterator.next().split(" ");

                String[] outString = inString;

                for (int i = 0; i < inString.length; i++) {
                    if (!inString[i].isEmpty()) {
                        outString[i] = inString[i].replaceAll("[^A-Za-z^-]", "");
                    }
                }
//                for (int i = 0; i < outString.length; i++) System.out.println("i = " + i + outString[i]);

                for (String str : outString) {
                    if (!(str.isEmpty())) {

                        // capturing the case of a single dash
                        if (str.contains("-") && !str.contains("--")) {
                            String[] extraWords = str.split("-");
                            for (String se : extraWords) {
                                writeOutInMap(wordsMap, se);
                            }
                        }
                        else
                            // capturing the case of a line with double dash
                            if (str.contains("--")) {
                                String[] doubleDashExtraWords = str.split("--");
                                for (String de : doubleDashExtraWords) {

                                    if (de.contains("-")) {
                                        String[] SingleDashExtraWords = de.split("-");
                                        for (String se : SingleDashExtraWords) {
                                            writeOutInMap(wordsMap, se);
                                        }
                                    }
                                    else {
                                        writeOutInMap(wordsMap, de);
                                    }
                                }
                            }
                            else
                                // regular case with no dashes in the line read
                                writeOutInMap(wordsMap, str);
                }
            }
        }

        // sub-task 1: Сосчитать частоту встречаемости слов в книге War and peace
        // outputting the whole list of the unique words encountered in the War & Peace by Leo Tolstoy
            wordsMap.forEach((k, v) ->
                    System.out.println("key=" + k + ", value=" + v));

        // sub-task 2: Собрать все слова в группы по количеству букв:
        // например, в одну группу попадут слова: [the, war, jar, get, met...], в другую [on, up, no, of...]
        // getting a list of top10 frequent words
        Metrics.getTop10(wordsMap);

        // sub-task 3: Вывести топ 10 самых частых слов
        // grouping the unique words as per the criterion of their length
        Metrics.getGroupedList(wordsMap);

        // sub-task 4: Тоже, что и 2, но без артиклей, частиц и тп (без the, a, on, to...)
        // applying an open list of exclusions while deriving a grouped list
        Metrics.getGroupedList(wordsMap,"the","to","a","on","up","am");

        // sub-task 5: Вывести частоту встречаемости букв анг алфавита по этой книге. Вывести в процентах для каждой буквы
        // tackling words onto letters and gauging the Freqs
        Words2Letters Freqs = new Words2Letters(wordsMap);
        Freqs.getAllFreq_A();
        Freqs.getTally();
    }
}
package homework.assignment_6;

import java.util.*;

class Metrics {

    public static void writeOutInMap(Map<String, Integer> wordsMap, String key) {
        if (wordsMap.containsKey(key.toUpperCase())) {
            wordsMap.put(key.toUpperCase(), wordsMap.get(key.toUpperCase()) + 1); }
        else wordsMap.put(key.toUpperCase(), 1);
    }

    public static void getTop10(Map<String, Integer> hashMap) {

        // decoupling the method parameter from the original object to avoid object mutation
        Map<String, Integer> inMap = new HashMap<String, Integer>(hashMap);

        Map<String, Integer> top10Map = new HashMap<>();

        for(int i = 1; i <= 10; i++) {
            Integer j = 0;
            String key = null;
            for (Map.Entry<String, Integer> entry : inMap.entrySet()) {
                if ( entry.getValue() > j) {
                    // System.out.println("control point");
                    j = entry.getValue();
                    key = entry.getKey();
                }
            }

            if (!top10Map.containsKey(key)) top10Map.put(key,j);
            inMap.remove(key, j);
        }

        System.out.println("Top10 list:");
        top10Map.forEach((k, v) ->
                System.out.println("key=" + k + ", value=" + v));
    }

    public static void getGroupedList(Map<String, Integer> hashMap) {
        int max_length = 0;
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            if(max_length < entry.getKey().length()) {
                max_length = entry.getKey().length();
            }
        }
        System.out.println(max_length);

        Map<String, Integer> groupedMap = new LinkedHashMap<>();
        Map<String, Integer> inMap = new HashMap<String, Integer>(hashMap);

        int j0 = 0; int jLast;
        for (int i=1; i <= max_length; i++) {
            jLast = j0;
            for (Map.Entry<String, Integer> entry : inMap.entrySet()) {
                if(entry.getKey().length() == i) {
                    jLast++;
                    groupedMap.put(entry.getKey(),entry.getValue());
                }
            }
            System.out.println("The group of words with " + i + " symbols starts from index " + (j0+1) +
                    " and ends at index " + jLast + ", i.e. in total accounts for " + (jLast - j0) + " words in the group");
            j0 = jLast;
        }
// printing out the elements of the grouped list of unique words (makes sense only if an excerpt from W&P is in use
        groupedMap.forEach((k, v) ->
                System.out.println("key=" + k + ", value=" + v));

    }

    public static void getGroupedList(Map<String, Integer> hashMap, String... exclusions) {
        int max_length = 0;
        ArrayList<String> exclList = new ArrayList<>(100);
        for(String e : exclusions) exclList.add(e.toUpperCase());

        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            if(max_length < entry.getKey().length()) {
                max_length = entry.getKey().length();
            }
        }
        System.out.println(max_length);

        Map<String, Integer> groupedMap = new LinkedHashMap<>();
        Map<String, Integer> inMap = new HashMap<String, Integer>(hashMap);

        int j0 = 0; int jLast;
        for (int i=1; i <= max_length; i++) {
            jLast = j0;
            for (Map.Entry<String, Integer> entry : inMap.entrySet()) {
                if(entry.getKey().length() == i && !checkExclusions(entry.getKey(),exclList)) {
// Debugging point:
// System.out.println(entry.getKey() + " || " + !checkExclusions(entry.getKey(),exclList) + " || " +
// exclList.toString());
                    jLast++;
                    groupedMap.put(entry.getKey(),entry.getValue());
                }
            }
            System.out.println("The group of words with " + i + " symbols starts from index " + (j0+1) +
                    " and ends at index " + jLast + ", i.e. in total accounts for " + (jLast - j0) + " words in the group");
            j0 = jLast;
        }
// printing out the elements of the grouped list of unique words (makes sense only if an excerpt from W&P is in use
//        groupedMap.forEach((k, v) ->
//                System.out.println("key=" + k + ", value=" + v));

    }

    private static boolean checkExclusions(String challenge, ArrayList<String> exclusions) {
        for(String e : exclusions) {
            if (challenge.equals(e)) {
                return true;
            }
        }
        return false;
    }
}

class Words2Letters {

    private Map<String, Integer> freqOnAlphabet = new HashMap<>();
    private static int total = 0;

    { // initialising the instance fields
        for (int j = 65; j <= 90; j++) {
            this.freqOnAlphabet.put(String.valueOf(Character.toChars(j)), 0);
        }
    }

    public Words2Letters(Map<String, Integer> vocabulary) {

        vocabulary.forEach((key, value) -> {
//            System.out.println("key = " + key);
            disperseByLetters(key);
        });
    }

    private void disperseByLetters(String word) {
//        System.out.println("word = " + word);
        for(int j = 0; j < word.length(); j++) {
//            System.out.println("j = " + j + " || " + word.charAt(j));
            if(this.freqOnAlphabet.containsKey(String.valueOf(word.charAt(j)))) {
                this.freqOnAlphabet.put(String.valueOf((word.charAt(j))),
                        this.freqOnAlphabet.get(String.valueOf((word.charAt(j)))) + 1);
            }
            else {
                this.freqOnAlphabet.put(String.valueOf((word.charAt(j))), 1);
            }
        }
    }

    public void getAllFreq_A() {
        this.freqOnAlphabet.forEach((k, v) ->
        System.out.println("key=" + k + ", value=" + v));
    }

    public void getTally() {
        freqOnAlphabet.forEach((key, value) -> { total+=value;

        });
        System.out.println("total = " + total);

        freqOnAlphabet.forEach((key, value) -> {
            System.out.println("The frequency of letter " + key + " is " + String.format("%.2f%%",100*value/(double)total));
        });
    }
}
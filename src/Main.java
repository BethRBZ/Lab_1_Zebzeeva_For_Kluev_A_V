import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String filename = "ёжик.txt";
        Scanner scanner = new Scanner(new File(filename));
        Map<String, Integer> wordCounts = new HashMap<>();
        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase(); // convert to lowercase
            word = word.replaceAll("[^A-Za-zА-Яа-я]", "");

            if (word.length() > 0) { // ignore empty/null strings
                if (wordCounts.containsKey(word)) {
                    wordCounts.put(word, wordCounts.get(word) + 1);
                } else {
                    wordCounts.put(word, 1);
                }
            }
        }
        for (String word : wordCounts.keySet()) {
            System.out.println(word + ": " + wordCounts.get(word));
        }
    }
}
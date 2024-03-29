import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;
import java.util.*;

public class SpellChecker {
    ArrayList<String> wordsList = new ArrayList<>();

    public SpellChecker(String fileName) {
        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {
                String data = reader.next();
                wordsList.add(data.toLowerCase());
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
        }
        System.out.println(wordsList);

    }

    public void checkSpelling(SpellChecker s) {
        SpellDictionary d = new SpellDictionary("words.txt");
        ArrayList<String> alreadyMissed = new ArrayList<>();
        System.out.println(wordsList.size());

        for (int i = 0; i < wordsList.size(); i++) {
            if (wordsList.get(i).endsWith(".") || wordsList.get(i).endsWith(",") || wordsList.get(i).endsWith("?")
                    || wordsList.get(i).endsWith("!") || wordsList.get(i).endsWith(";")
                    || wordsList.get(i).endsWith(":")) {
                wordsList.set(i, wordsList.get(i).substring(0, wordsList.get(i).length() - 1));
            }

            if (wordsList.get(i).startsWith("-")) {
                wordsList.set(i, wordsList.get(i).substring(i));
            }

            if (!d.containsWord(wordsList.get(i)) && !alreadyMissed.contains(wordsList.get(i))) {
                alreadyMissed.add(wordsList.get(i));
                System.out.println("Not found: " + wordsList.get(i));
                System.out.println("Suggestion: " + d.nearMisses(wordsList.get(i)));
            }
        }

    }

    // command line prompt
    public static void main(String[] args) {
        SpellDictionary d = new SpellDictionary("words.txt");

        if (args.length > 1) {
            for (String word : args) {
                if (d.containsWord(word)) {
                    System.out.println("'" + word + "'" + " is spelled correctly.");
                } else {
                    System.out.println("Not found: " + word);
                    System.out.println("Suggestions: " + d.nearMisses(word));
                }
            }
        } else if (args.length == 1) {
            SpellChecker sonnet = new SpellChecker(args[0]);
            sonnet.checkSpelling(sonnet);
        } else {
            System.out.println("Cannot process");
        }

    }

}

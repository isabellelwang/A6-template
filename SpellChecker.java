import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class SpellChecker {
    ArrayList<String> wordsList = new ArrayList<>();

    /**
     * Reads file and adds each word to 
     * 
     * @param fileName String file to be opened 
     */
    public SpellChecker(String fileName) {
        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {
                String data = reader.next();
                wordsList.add(data.toLowerCase());
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
        }
        System.out.println(wordsList);
    }

    /**
     * prints out suggestions for incorrect spelled words 
     * 
     * @param s SpellChecker with opened file
     */
    public void checkSpelling(SpellChecker s) {
        SpellDictionary d = new SpellDictionary("words.txt");
        ArrayList<String> alreadyMissed = new ArrayList<>();

        // \\p{Punct}
        for (int i = 0; i < wordsList.size(); i++) {
            if (wordsList.get(i).endsWith("\\p{Punct}")) {
                wordsList.set(i, wordsList.get(i).substring(0, wordsList.get(i).length() - 1));
            }

            if (wordsList.get(i).startsWith("\\\\p{Punct}")) {
                wordsList.set(i, wordsList.get(i).substring(i));
            }

            if (!d.containsWord(wordsList.get(i)) && !alreadyMissed.contains(wordsList.get(i))) {
                alreadyMissed.add(wordsList.get(i));
                System.out.println("Not found: " + wordsList.get(i));
                System.out.println("Suggestion: " + d.nearMisses(wordsList.get(i)));
            }
        }
    }

    /**
     * prints out suggestions for words not found in dictionary and checks if words are correct
     * 
     * @param wordsList ArrayList of words in sonnet
     */
    public static void checkSpelling(ArrayList<String> wordsList) {
        SpellDictionary d = new SpellDictionary("words.txt");
        ArrayList<String> alreadyMissed = new ArrayList<>();

        // \\p{Punct} 
        for (int i = 0; i < wordsList.size(); i++) {
            if (wordsList.get(i).endsWith("\\p{Punct}")) {
                wordsList.set(i, wordsList.get(i).substring(0, wordsList.get(i).length() - 1));
            }

            //start w/ punc
            if (wordsList.get(i).startsWith("\\\\p{Punct}")) {
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
        } else {
            Scanner input = new Scanner(System.in);
            ArrayList<String> data = new ArrayList<>();

            while (input.hasNext()) {
                data.add(input.next().replaceAll("\\p{Punct}", "").toLowerCase());
                // System.out.println(input.next().replaceAll("\\p{Punct}", "").toLowerCase());
            }
            input.close();
            SpellChecker.checkSpelling(data);
        }
    }
}

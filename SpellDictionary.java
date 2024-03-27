import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;

public class SpellDictionary implements SpellingOperations {

    HashSet<String> dictionary = new HashSet<>();
    String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public SpellDictionary(String fileName) {
        try {

            File file = new File(fileName);
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                dictionary.add(data);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.err.println("No file found");
        }
    }

    /**
     * @param query the word to check
     * @return true if the query word is in the dictionary.
     */
    public boolean containsWord(String query) {
        return dictionary.contains(query);
    }

    /**
     * @param query the word to check
     * @return a list of all valid words that are one edit away from the query
     */
    public ArrayList<String> nearMisses(String query) {
        ArrayList<String> newWords = new ArrayList<>();

        ArrayList<String> queryList = new ArrayList<>();
        for (int i = 0; i < query.length(); i++) {
            queryList.add(query.substring(i, i + 1));
        }

        // Deletion
        for (int i = 0; i < query.length(); i++) {
            String deletedFirst = query.substring(i, query.length());
            String deletedSecond = query.substring(i, i+1) + query.substring(i+2); 
            System.out.println(deletedFirst + " " + deletedSecond);
            if (dictionary.contains(deletedFirst)) {
                newWords.add(deletedFirst);
                System.out.println(newWords);
            }
            if(dictionary.contains(deletedSecond)) {
                newWords.add(deletedSecond); 
            }
        }

        for(int i = 0; i < query.length() - 1; i++) {
            for(int j = i + 1; j < query.length(); j++) {
                

            }
        }

        // Insertions
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            for (int i = 0; i < query.length() - 1; i++) {
                String newWord = query.substring(i, i + 1) + String.valueOf(ch) + query.substring(i + 3);
            }
        }

        // substitutiions
        for (int i = 0; i < 25 * query.length(); i++) {

        }

        // transposition
        for (int i = 0; i < query.length() - 1; i++) {

        }

        // Splits
        for (int i = 0; i < query.length() - 1; i++) {

        }

        return newWords;

    }

    public static void main(String[] args) {
        // for (char ch = 'A'; ch <= 'Z'; ch++) {
        // System.out.println(ch);
        // }
        SpellDictionary d = new SpellDictionary("words.txt");
        d.nearMisses("hello");

    }

}
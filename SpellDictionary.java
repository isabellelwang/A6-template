import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;
import java.util.*;

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
        ArrayList<String> misses = new ArrayList<>();

        // // // Deletion
        // for (int i = 0; i < query.length(); i++) {
        // String newWord = query.substring(i);
        // System.out.println(newWord);
        // if (dictionary.contains(newWord) && !misses.contains(newWord)) {
        // misses.add(newWord);
        // System.out.println(misses);
        // }
        // }

        // // Insertion
        // // make arraylist
        // ArrayList<String> queryList = new ArrayList<>();
        // for (int i = 0; i < query.length(); i++) {
        // queryList.add(query.substring(i, i + 1));
        // }

        // for (int i = 0; i < query.length() + 1; i++) {
        // for (char c = 'a'; c <= 'z'; c++) {

        // queryList.add(i, String.valueOf(c));

        // StringBuilder word = new StringBuilder();
        // for (String l : queryList) {
        // word.append(l);
        // }
        // String insertedWord = word.toString();
        // System.out.println(insertedWord);

        // if (dictionary.contains(insertedWord) && !misses.contains(insertedWord)) {
        // System.out.println("in");
        // misses.add(insertedWord);
        // }
        // // reverts list back to normal (without added letter)
        // queryList.remove(i);
        // }
        // }

        // // substitutiions
        // char queryArr[] = query.toCharArray();
        // for (int i = 0; i < query.length(); i++) {
        // queryArr = query.toCharArray();
        // for (char c = 'A'; c <= 'Z'; c++) {

        // queryArr[i] = Character.toLowerCase(c);

        // StringBuilder word = new StringBuilder();
        // for (char l : queryArr) {
        // word.append(l);
        // }

        // String newWord = word.toString();
        // if (dictionary.contains(newWord) && !misses.contains(newWord)) {
        // //System.out.println("added");
        // misses.add(newWord);
        // System.out.println(misses);
        // }
        // }
        // }

        // transposition
        char queryArr[] = query.toCharArray();
        char firstL;
        char secondL;
        for (int i = 0; i < query.length() - 1; i++) {
            firstL = queryArr[i];
            secondL = queryArr[i + 1];
            queryArr[i] = secondL;
            queryArr[i + 1] = firstL;

            System.out.println(queryArr);

            StringBuilder wordBuilder = new StringBuilder();

            for (char l : queryArr) {
                wordBuilder.append(l);
            }

            String word = wordBuilder.toString();
            System.out.println(word);
            if (dictionary.contains(word) && !misses.contains(word)) {
                misses.add(word);
            }
            queryArr[i] = firstL;
            queryArr[i + 1] = secondL;
        }

        // Splits
        for (int i = 0; i < query.length() - 1; i++) {

        }

        return misses;

    }

    public static void main(String[] args) {
        // for (char ch = 'A'; ch <= 'Z'; ch++) {
        // System.out.println(ch);
        // }
        SpellDictionary d = new SpellDictionary("words.txt");
        d.nearMisses("cattel");

    }

}
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;

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

        ArrayList<String> queryList = new ArrayList<>();
        for (int i = 0; i < query.length(); i++) {
            queryList.add(query.substring(i, i + 1));
        }

        // Deletion
        // for(int i = 0; i < query.length(); i++) {
        // String newWord = query.substring(i);
        // System.out.println(newWord);
        // if(dictionary.contains(newWord) && !misses.contains(newWord)) {
        // misses.add(newWord);
        // System.out.println(misses);
        // }
        // }

        // // Insertions
        // for (char ch = 'A'; ch <= 'Z'; ch++) {
        // for (int i = 0; i < query.length() - 1; i++) {
        // String newWord = query.substring(i, i + 1) + String.valueOf(ch) +
        // query.substring(i + 3);
        // }
        // }

        // substitutiions
        char queryArr[] = query.toCharArray();
        // System.out.println(querArr[1]);
        // char queryArr[] = new char[query.length()];
        // for(int i = 0; i < query.length(); i++) {
        // queryArr[i] = query.charAt(query.indexOf(query.substring(i, i+1)));
        // }
        // System.out.println(queryArr[0]);

        for (int i = 0; i < query.length(); i++) {
            queryArr = query.toCharArray();
            for (char c = 'A'; c <= 'Z'; c++) {
                if (i == 0) {
                    queryArr[i] = c;
                } else {
                    queryArr[i] = Character.toLowerCase(c);
                }
                String newWord = Arrays.toString(queryArr);
                if (dictionary.contains(newWord) && !misses.contains(newWord)) {
                    misses.add(newWord);
                }
            }
        }

        // transposition
        for (int i = 0; i < query.length() - 1; i++) {

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
        d.nearMisses("cattle");

    }

}
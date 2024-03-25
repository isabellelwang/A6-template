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

        //Deletion
        for(int i = 0; i < query.length(); i++) {
            String newDeletedWord = query.substring(i, query.length()); 
            if(dictionary.contains(newDeletedWord)) {
                newWords.add(newDeletedWord); 
            }
        }

        //Insertions
        for(int i = 0; i < 26*(query.length() + 1); i++) {
            String addLetterWord = 

        }

        for(int i = 0; i < 25 * n; i++) {
            
        }


        

    }

}
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;
import java.util.*;

public class SpellChecker {

    public SpellChecker(String file) {
        File 
    }

    // command line prompt
    public static void main(String[] args) {

        SpellDictionary d = new SpellDictionary("words.txt");

        for (String word : args) {
            if (d.containsWord(word)) {
                System.out.println("'" + word + "'" + " is spelled correctly.");
            } else {
                System.out.println("Not found: " + word);
                System.out.println("Suggestions: " + d.nearMisses(word));
            }
        }
    }

}

public class Main {
    public static void main(String[] args) {
        SpellDictionary dict = new SpellDictionary("words.txt");

        // test containsWord
        System.out.println(dict.containsWord("Debby"));

        System.out.println("Testing Deletion");
        System.out.println("Near Misses for helllo: " + dict.nearMisses("helllo"));
        System.out.println("Near Misses for caattle: " + dict.nearMisses("caattle"));
        System.out.println("Near Misses for on: " + dict.nearMisses("on"));

        System.out.println("Testing Insertion");
        System.out.println("Near Misses for helo: " + dict.nearMisses("helo"));
        System.out.println("Near Misses for cttle: " + dict.nearMisses("cttle"));
        System.out.println("Near Misses for an: " + dict.nearMisses("an"));

        System.out.println("Testing Substitution");
        System.out.println("Near Misses for h: " + dict.nearMisses("h"));
        System.out.println("Near Misses for yup: " + dict.nearMisses("yup"));

        System.out.println("Testing Transposition");
        System.out.println("Near Misses for cattel: " + dict.nearMisses("cattel"));
        System.out.println("Near Misses for cattel: " + dict.nearMisses("hlelo"));

        System.out.println("Testing Split");
        System.out.println("Near Misses for cattell: " + dict.nearMisses("cattell"));
        System.out.println("Near Misses for papermate: " + dict.nearMisses("papermate"));

    }

}

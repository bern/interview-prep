// A kidnapper wrote a ransom note but is worried it will be traced back to him.
// He found a magazine and wants to know if he can cut out whole words from it
// and use them to create an untraceable replica of his ransom note. The words in
// his note are case-sensitive and he must use whole words available in the
// magazine, meaning he cannot use substrings or concatenation to create the
// words he needs.

// Given the words in the magazine and the words in the ransom note, print Yes if
// he can replicate his ransom note exactly using whole words from the magazine;
// otherwise, print No.

import java.util.*;

public class HashTablesRansomNote {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // Length of magazine.
    int m = in.nextInt();

    // Length of note.
    int n = in.nextInt();

    // Failure case.
    if (m < n) {
      System.out.println("No");
      return;
    }

    // Count all occurrences of all words.
    HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
    for (int i = 0; i < m; i++) {
      String word = in.next();
      if (wordCount.get(word) == null) {
        wordCount.put(word, 1);
      } else {
        wordCount.put(word, wordCount.get(word) + 1);
      }
    }

    // Check for each word and decrement its occurrence count, removing if 0.
    for (int i = 0; i < n; i++) {
      String word = in.next();
      if (wordCount.get(word) != null) {
        int decCount = wordCount.get(word) - 1;
        if (decCount == 0) {
          wordCount.remove(word);
        } else {
          wordCount.put(word, decCount);
        }
      } else {
        // Failed to find a necessary word. Failing.
        System.out.println("No");
        return;
      }
    }
    // No failures means we did it!
    System.out.println("Yes");
  }
}

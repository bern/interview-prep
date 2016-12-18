// Alice is taking a cryptography class and finding anagrams to be very useful.
// We consider two strings to be anagrams of each other if the first string's
// letters can be rearranged to form the second string. In other words, both
// strings must contain the same exact letters in the same exact frequency.
// For example, bacdc and dcbac are anagrams, but bacdc and dcbad are not.

// Alice decides on an encryption scheme involving two large strings where
// encryption is dependent on the minimum number of character deletions required
// to make the two strings anagrams. Can you help her find this number?

// Given two strings, a and b, that may or may not be of the same length,
// determine the minimum number of character deletions required to make a and b
// anagrams. Any characters can be deleted from either of the strings.

// Both strings will strictly consist of lowercase letters a-z.

import java.util.*;

public class StringsMakingAnagrams {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    String a = in.next();
    String b = in.next();

    System.out.println(deleteDiff(a, b));
  }

  // Brute force solution: count number of each letter in each string.
  // Iterate through map and count the difference for each letter.
  public static int deleteDiff(String a, String b) {
    // Store character counts in maps.
    HashMap<Character, Integer> a_ = new HashMap<Character, Integer>();
    HashMap<Character, Integer> b_ = new HashMap<Character, Integer>();

    // Store character counts for string a.
    for(int i = 0; i < a.length(); i++) {
      char aC = a.charAt(i);

      if (a_.get(aC) == null) {
        a_.put(aC, 1);
      } else {
        a_.put(aC, a_.get(aC) + 1);
      }
    }

    // Store character counts for string b.
    for(int i = 0; i < b.length(); i++) {
      char bC = b.charAt(i);

      if (b_.get(bC) == null) {
        b_.put(bC, 1);
      } else {
        b_.put(bC, b_.get(bC) + 1);
      }
    }

    int diff = 0;

    // Iterate thru map a_. If the letter exists in string b, add the absolute
    // difference between the two counts to our "to-be-deleted" count. Then
    // remove it from map b_ (to prevent repeat counts).

    // If the letter does not exist in string b, it must be completely deleted
    // so add its full count to our "to-be-deleted" count.
    Iterator it = a_.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry pair = (Map.Entry)it.next();
      char aC = (char)pair.getKey();
      if(b_.get(aC) == null) {
        diff += a_.get(aC);
      } else {
        diff += Math.abs(a_.get(aC) - b_.get(aC));
        b_.remove(aC);
      }
      it.remove();
    }

    // Iterate thru map b_. If the letter does not exist in string b, it must be
    // completely deleted so add its full count to our "to-be-deleted" count.
    it = b_.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry pair = (Map.Entry)it.next();
      char bC = (char)pair.getKey();
      diff += b_.get(bC);
      it.remove();
    }

    // Return final "to-be-deleted" count.
    return diff;
  }
}

/*

  NOTE: INCOMPLETE

*/

// We're going to make our own Contacts application! The application must
// perform two types of operations:

// add name, where name is a string denoting a contact name. This must store
// name as a new contact in the application.

// find partial, where partial is a string denoting a partial name to search the
// application for. It must count the number of contacts starting with partial
// and print the count on a new line.

// Given n sequential add and find operations, perform each operation in order.

import java.util.*;

public class TrieContacts {
  public static HashSet<String> wordsInDict = new HashSet<String>();
  public static HashMap<String, Integer> numPrefixedWords = new HashMap<String, Integer>();

  public static void main(String[] args) {
    /*
    Trie t = new Trie();
    t.insert("hacker");
    t.insert("hackerr");
    t.insert("have");
    t.insert("haste");

    String prefix = "ha";
    Trie prefixNode = t.findPrefixNode(prefix);
    if (prefixNode != null) {
      System.out.println(prefixNode.value);
      System.out.println("Found "+prefixNode.countLeaves()+" entries with this prefix!");
    } else {
      System.out.println("Couldn\'t find the node!");
    }
    */

    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    Trie trie = new Trie();
    while(t-->0) {
      String cmd = in.next();
      if (cmd.equals("add")) {
        String s = in.next();
        if (wordsInDict.contains(s)) {
          continue;
        } else {
          trie.insert(s);
          wordsInDict.add(s);
        }
      } else {


        String s = in.next();
        if (numPrefixedWords.get(s) != null) {
          System.out.println(numPrefixedWords.get(s));
        } else {
          Trie prefNode = trie.findPrefixNode(s);
          if (prefNode == null) {
            System.out.println(0);
            numPrefixedWords.put(s, 0);
          } else {
            int leafCount = prefNode.countLeaves();
            System.out.println(leafCount);
            numPrefixedWords.put(s, leafCount);
          }
        }


      }
    }
  }
}

class Trie {
    public String value;
    public HashMap<Character, Trie> children;
    public boolean isWord;

    public Trie() {
      value = "";
      children = new HashMap<Character, Trie>();
      isWord = false;
    }

    public Trie(String v) {
      value = v;
      children = new HashMap<Character, Trie>();
      isWord = false;
    }

    public void insert(String s) {
      if (s.length() == 0) {
        this.isWord = true;
        return;
      }

      char c = s.charAt(0);

      // if s.charAt(0) is mapped to a trie, insert into it.
      if (children.get(c) == null) {
        children.put(c, new Trie(value + c));
      }

      if (s.length() >= 2) {
        String slicedString = s.substring(1, s.length());
        children.get(c).insert(slicedString);
      } else {
        children.get(c).insert("");
      }
    }

    public Trie findPrefixNode(String s) {
      if (s.length() == 0) return this;

      char c = s.charAt(0);

      if (children.get(c) != null) {
        if (s.length() >= 2) {
          return children.get(c).findPrefixNode(s.substring(1, s.length()));
        } else {
          return children.get(c);
        }
      }

      return null;
    }

    public int countLeaves() {
      if (children.size() == 0) return 1;

      int sum = 0;

      if (isWord) sum++;

      Iterator it = children.entrySet().iterator();
      while (it.hasNext()) {
          Map.Entry pair = (Map.Entry)it.next();

          sum += ((Trie)pair.getValue()).countLeaves();


      }
      return sum;
    }
}

// We say a sequence of brackets is considered to be balanced if
// the following conditions are met:

// It contains no unmatched brackets.
// The subset of brackets enclosed within the confines of a matched pair of
// brackets is also a matched pair of brackets.

// Given n strings of brackets, determine whether each sequence of brackets is
// balanced. If a string is balanced, print YES on a new line; otherwise, print
// NO on a new line.

import java.util.*;

public class StacksBalancedBrackets {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int t = in.nextInt();
    while(t-->0) {
      System.out.println(isBalanced(in.next()) ? "YES" : "NO");
    }
  }

  public static boolean isBalanced(String brackets) {
    Stack<Character> stack = new Stack<Character>();
    for(int i = 0; i < brackets.length(); i++) {
      char c = brackets.charAt(i);

      if (!stack.empty() && stack.peek() == opposite(c)) {
        stack.pop();
        continue;
      }

      stack.push(c);
    }
    return stack.empty();
  }

  public static char opposite(char c) {
    if (c == ')') return '(';
    if (c == '}') return '{';
    if (c == ']') return '[';
    return ' ';
  }
}

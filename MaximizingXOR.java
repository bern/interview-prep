// Given two integers, L and R, find the maximal value of A xor B, where A and B
// satisfy the following condition: L <= A <= B <= R.

// Note that R will always be LEQ 100. Brute force should be fine.

import java.util.*;
import java.lang.*;

public class MaximizingXOR {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int l = in.nextInt();
    int r = in.nextInt();

    int max = 0;

    // Brute force.
    for(int a = l; a <= r; a++) {
      for(int b = a; b <= r; b++) {
        // Result is the maximum between the current max
        // and the value of an XOR op between a and b.
        max = Math.max(max, a^b);
      }
    }

    // Print the result!
    System.out.println(max);
  }
}

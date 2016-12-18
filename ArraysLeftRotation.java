// A left rotation operation on an array of size n shifts each of the array's
// elements n unit to the left. For example, if 2 left rotations are performed
// on array [1, 2, 3, 4, 5], then the array would become [3, 4, 5, 1, 2].

// Given an array of n integers and a number, d, perform d left rotations on the
// array. Then print the updated array as a single line of space-separated
// integers.

// 1 <= n <= 100000 (int)
// 1 <= d <= n (int)
// 1 <= a_i <= 1000000 (int)

import java.util.*;

public class ArraysLeftRotation {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // Size of the array.
    int n = in.nextInt();

    // Number of rotations (LEQ n).
    int d = in.nextInt();

    int[] result = new int[n];

    for(int i = 0; i < n; i++) {
      int newIndex = i - d;
      if(newIndex < 0) {
        newIndex = (i + n) - d;
      }
      result[newIndex] = in.nextInt();
    }

    for(int i = 0; i < n; i++) {
      System.out.print(result[i]+" ");
    }
  }
}

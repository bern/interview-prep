// The Hamming distance between two integers is the number of positions at which
// the corresponding bits are different.

// Given two integers x and y, calculate the Hamming distance.

import java.lang.*;

public class HammingDistance {
  public static void main(String[] args) {
    int x = 1;
    int y = 4;

    System.out.println(hammingDistance(x, y));
  }

  public static int hammingDistance(int x, int y) {
    int z = x^y;
    int count = 0;
    while(z != 0) {
      z = z & (z-1);
      count++;
    }
    return count;
  }
}

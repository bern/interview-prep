// Louise and Richard play a game. They have a counter set to N. Louise gets the
// first turn and the turns alternate thereafter. In the game, they perform the
// following operations:

// If N is not a power of 2, reduce the counter by the largest power of 2 less
// than N.

// If N is a power of 2, reduce the counter by half of N.

// The game ends when the counter reduces to 1, i.e., N == 1, and the last
// person to make a valid move wins. Given N, your task is to find the winner
// of the game.

// If N starts as 1, Richard wins because it is Louise's turn and she cannot
// make a move.

// 1 <= T <= 10 (int, testcases)
// 1 <= N <= 2^64-1 (BigInteger)

import java.util.*;
import java.lang.*;
import java.math.*;

public class CounterGame {

  public static final BigInteger ONE = new BigInteger("1");
  public static final BigInteger ZERO = new BigInteger("0");

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int t = in.nextInt();
    while(t-->0) {
      // BigIntegers because java long only holds up to (2^63)-1.
      BigInteger n = in.nextBigInteger();
      System.out.println(determineWinner(n));
    }
  }

  public static String determineWinner(BigInteger n) {
    if (n.equals(ONE)) return "Richard";

    boolean richardTurn = true;

    while (n.compareTo(ONE) == 1) {
      // Advance turn designation.
      richardTurn = !richardTurn;

      // If n is a power of 2, that is if n & (n-1) == 0...
      if ((n.and(new BigInteger(n.subtract(ONE).toString()))).equals(ZERO)) {
        // Counter is cut in half.
        n = n.divide(new BigInteger("2"));
      } else {
        // If n is not a power of 2,
        // reduce by next largest power of 2.
        BigInteger temp = new BigInteger(n.toString());

        // Determine next largest power of 2.
        // If temp & (temp-1) != ZERO (not a power of 2)...
        while (!((temp.and(new BigInteger(temp.subtract(ONE).toString()))).equals(ZERO))) {
          // Remove rightmost "1" from temp by performing temp & (temp-1).
          temp = (temp.and(new BigInteger(temp.subtract(ONE).toString())));
        }

        // Decrease n by temp.
        n = n.subtract(temp);
      }
    }

    return richardTurn ? "Richard" : "Louise";
  }
}

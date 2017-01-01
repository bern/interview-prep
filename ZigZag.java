import java.util.*;
import java.lang.*;

public class ZigZag {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    System.out.print("Sequence Length: ");
    int n = in.nextInt();

    int[] s = new int[n];

    for(int i = 0; i < n; i++) {
      System.out.print("Element "+i+": ");
      s[i] = in.nextInt();
    }
    System.out.println();

    int[][] dp = new int[n][n];
    for(int r = 0; r < n; r++) {
      for(int c = 0; c < n; c++) {
        if(r == 0) {
          dp[r][c] = 1;
          continue;
        }
        if(r > c) {
          dp[r][c] = dp[r-1][c];
          continue;
        }
        if(dp[r-1][c-1] == 1) {
          if(s[c] != s[c-1]) {
            dp[r][c] = s[c] > s[c-1] ? (-2) : 2;
            continue;
          }
          dp[r][c] = 1;
          continue;
        }
        if(dp[r-1][c-1] < 0) {
          if(s[c] - s[c-1] < 0) {
            dp[r][c] = (dp[r-1][c-1] * (-1)) + 1;
            continue;
          }
          dp[r][c] = dp[r-1][c-1];
          continue;
        }
        else {
          if(s[c] - s[c-1] > 0) {
            dp[r][c] = (dp[r-1][c-1] + 1) * (-1);
            continue;
          }
          dp[r][c] = dp[r-1][c-1];
          continue;
        }
      }
    }
    System.out.println("DP Matrix: ");
    for(int r = 0; r < n; r++) {
      for(int c = 0; c < n; c++) {
        System.out.print(Math.abs(dp[r][c])+" ");
      }
      System.out.println();
    }
    System.out.println();

    System.out.println("Longest ZigZag subsequence is length: "+Math.abs(dp[n-1][n-1]));
  }
}

import java.util.*;
import java.lang.*;

public class LongestCommonSubsequence {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    System.out.print("String a: ");
    String a = in.next();

    System.out.print("String b: ");
    String b = in.next();

    System.out.println();

    int dp[][] = new int[b.length()+1][a.length()+1];

    for(int r = 0; r < dp.length; r++) {
      for(int c = 0; c < dp[r].length; c++) {
        if(r == 0 || c == 0) {
          dp[r][c] = 0;
          continue;
        }

        if(a.charAt(c-1) == b.charAt(r-1)) {
          dp[r][c] = dp[r-1][c-1] + 1;
        } else {
          dp[r][c] = Math.max(dp[r-1][c], dp[r][c-1]);
        }
      }
    }

    System.out.println("DP Matrix");
    for(int r = 0; r < dp.length; r++) {
      for(int c = 0; c < dp[r].length; c++) {
        System.out.print(dp[r][c]+" ");
      }
      System.out.println();
    }

    int subLength = dp[dp.length-1][dp[0].length-1];
    char[] longestSubsequence = new char[subLength];

    int ind = subLength-1;
    int r = dp.length-1; int c = dp[0].length-1;
    int currentScore = subLength;
    while(ind >= 0) {
      if(dp[r][c-1] == currentScore) {
        c--;
      } else if(dp[r-1][c] == currentScore) {
        r--;
      } else {
        longestSubsequence[ind] = a.charAt(c-1);
        currentScore = ind;
        c--; r--; ind--;
      }
    }

    System.out.println();

    System.out.print("Longest common subsequence: ");
    for(char ch: longestSubsequence) {
      System.out.print(ch);
    }
    System.out.println();
  }
}

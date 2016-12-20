import java.util.*;
import java.lang.*;

public class ZeroOneKnapsack {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    System.out.print("Total weight you can carry: ");
    int m = in.nextInt();

    System.out.print("Total number of items: ");
    int n = in.nextInt();

    System.out.println();

    Item[] items = new Item[n];
    for(int i = 0; i < items.length; i++) {
      System.out.println("Item "+i);
      System.out.print("Weight: ");
      int w = in.nextInt();
      System.out.print("Value: ");
      int v = in.nextInt();
      System.out.println();
      items[i] = new Item(w, v);
    }

    int[][] dp = new int[n][m+1];
    for(int r = 0; r < dp.length; r++) {
      for(int c = 0; c < dp[r].length; c++) {
        if(c == 0) {
          dp[r][c] = 0;
          continue;
        }
        if(r == 0) {
          if(items[r].w > c) {
            dp[r][c] = 0;
          } else {
            dp[r][c] = items[r].v;
          }
          continue;
        }
        if(items[r].w > c) {
          dp[r][c] = dp[r-1][c];
        } else {
          dp[r][c] = Math.max(items[r].v+dp[r-1][c-items[r].w], dp[r-1][c]);
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
    System.out.println();
    System.out.println("Used items");

    int r = dp.length-1; int c = dp[r].length-1;
    while(!(c == 0)) {
      if(dp[r-1][c] != dp[r][c]) {
        System.out.print(r+" ");
        c = c-items[r].w;
      }
      r--;
    }
    System.out.println();
  }
}

class Item {
  public int w;
  public int v;

  public Item(int w, int v) {
    this.w = w; this.v = v;
  }
}

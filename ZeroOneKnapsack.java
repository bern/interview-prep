import java.util.*;
import java.lang.*;

public class ZeroOneKnapsack {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    System.out.print("Total weight you can carry: ");
    int m = in.nextInt();

    System.out.print("Total number of items: ");
    int n = in.nextInt();

    Item[] items = new Item[n];
    for(int i = 0; i < item.length; i++) {
      System.out.println("Item "+i);
      System.out.print("Weight: ");
      int w = in.nextInt();
      System.out.print("Value: ");
      int v = in.nextInt();
      System.out.println();
      items[i] = new Item(w, v);
    }

    int[][] dp = new int[n][m];
    for(int r = 0; r < n; r++) {
      for(int c = 0; c < m; c++) {
        if(c == 0) {
          dp[r][c] = 0;
          continue;
        }

        // if(items[r].w < c)
      }
    }
  }
}

class Item {
  public int w;
  public int v;

  public Item(int w, int v) {
    this.w = w; this.v = v;
  }
}

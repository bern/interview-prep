import java.util.*;

public class RecursionDavisStaircase {
  public static HashMap<Integer, Integer> stepsToWays = new HashMap<Integer, Integer>();

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int n = in.nextInt();

    while(n-->0) {
      System.out.println(steps(in.nextInt()));
    }
  }

  public static int steps(int n) {
    if (n == 0) return 1;
    if (n < 0) return 0;

    if (stepsToWays.get(n) != null) {
      return stepsToWays.get(n);
    } else {
      stepsToWays.put(n, steps(n-1) + steps(n-2) + steps(n-3));
    }

    return steps(n-1) + steps(n-2) + steps(n-3);
  }
}

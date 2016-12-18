import java.util.*;

public class BFSImpl {
  public static HashSet<Pair> visited;

  // 0 == UP, 1 == RIGHT, 2 == DOWN, 3 == LEFT
  public static final int[] dr = {-1,0,1,0};
  public static final int[] dc = {0,1,0,-1};

  public static void main(String[] args) {
    int[][] m = {{1,2,3}, {4,5,6}, {7,8,9}};

    printMat(m);
    bfs(m, 0, 0);
  }

  public static void bfs(int[][] m, int startR, int startC) {
    int rows = m.length;
    int columns = m[0].length;
    visited = new HashSet<Pair>();
    Queue<Pair> bfs = new LinkedList<Pair>();
    Pair start = new Pair(startR, startC);
    bfs.add(start);
    visited.add(start);
    while(!bfs.isEmpty()) {
      Pair p = bfs.remove();

      int r = p.r; int c = p.c;
      System.out.print(m[p.r][p.c]+" ");

      for(int i = 0; i < dr.length; i++) {
        int nextR = r + dr[i]; int nextC = c + dc[i];
        if(canVisit(m, nextR, nextC, rows, columns)) {
          bfs.add(new Pair(nextR, nextC));
          visited.add(new Pair(nextR, nextC));
        }
      }
    }
    System.out.println();
  }

  public static boolean canVisit(int[][] m, int nextR, int nextC, int rows, int columns) {
    if(visited.contains(new Pair(nextR, nextC))) {
      return false;
    }
    if(nextR < 0 || nextR >= rows || nextC < 0 || nextC >= columns) {
      return false;
    }
    return true;
  }

  public static void printMat(int[][] m) {
    System.out.println("Matrix:");
    for(int r = 0; r < m.length; r++) {
      for(int c = 0; c < m[r].length; c++) {
        System.out.print(m[r][c]+" ");
      }
      System.out.println();
    }
    System.out.println();
  }
}

class Pair {
  public int r;
  public int c;

  public Pair(int r, int c) {
    this.r = r; this.c = c;
  }

  public int hashCode() {
    return r ^ c;
  }

  public boolean equals(Object o) {
    Pair p = (Pair) o;
    return this.r == p.r && this.c == p.c;
  }
}

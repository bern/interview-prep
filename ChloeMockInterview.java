import java.io.*;
import java.util.*;
import java.lang.*;

/* Task: Print a matrix in spiral, clockwise order. */

// m x n matrix, not necessarily square.

// Create a Pair class to represent r,c coordinates
// Every time we visit an element of the matrix, add its r,c coordinates to a set
// Have 4 modes.. right, down, left, up that cycle every time we hit EITHER
// a) a boundary
// b) a visited coordinate pair

/*
 c->
r1   2  3
v4   5  6
 7   8  9
 10 11 12

 1 2 3 6 9 12 11 10 7 4 5 8

1 2 3 6 9 8 7 4 5

*/

class ChloeMockInterview {

  public static HashSet<Pair> visited = new HashSet<Pair>();

  public static void main(String[] args) {
    int[][] m = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
    int rTotal = 4; int cTotal = 3;

    int[] spiral = makeSpiral(m, rTotal, cTotal);
    for(int i = 0; i < spiral.length; i++) {
      System.out.print(spiral[i]+" ");
    }
  }

  public static int[] makeSpiral(int[][] m, int rTotal, int cTotal) {
    int matSize = rTotal*cTotal;
    int[] spiral = new int[matSize];
    int mode = 0;
    // Have 4 modes..
    // ind0 = RIGHT, ind1 = DOWN, ind2 = LEFT, ind3 = UP
    int[] dr = {0, 1, 0, -1};
    int[] dc = {1, 0, -1, 0};

    int cellsVisited = 0;
    int curr_r = 0; int curr_c = 0;
    while (cellsVisited < matSize) {
      spiral[cellsVisited] = m[curr_r][curr_c];
      visited.add(new Pair(curr_r, curr_c));

      // if we can advance forward in our current mode, do so
      if(moveIsValid(mode, curr_r, curr_c, dr, dc, rTotal, cTotal)) {
        curr_r += dr[mode];
        curr_c += dc[mode];
      }
      // else, change modes and advance forward
      else {
        mode = ((mode+1)%dr.length);
        curr_r += dr[mode];
        curr_c += dc[mode];
      }

      cellsVisited++;
    }

    return spiral;
  }

  public static boolean moveIsValid(int mode, int curr_r, int curr_c, int[] dr, int[] dc, int rTotal, int cTotal) {
    // Move is invalid IF
    int next_r = curr_r + dr[mode];
    int next_c = curr_c + dc[mode];
    // next coordinate has been visited
    if(visited.contains(new Pair(next_r, next_c))) {
      return false;
    }
    // next coordinate is out of bounds
    if(next_r < 0 || next_r >= rTotal || next_c < 0 || next_c >= cTotal) {
      return false;
    }
    return true;
  }
}

class Pair {
  public int r;
  public int c;

  public Pair (int r, int c) {
    this.r = r;
    this.c = c;
  }

  public int hashCode() {
    return r ^ c;
  }

  public boolean equals (Object o) {
    Pair p = (Pair) o;
    if (this.r == p.r && this.c == p.c) {
      return true;
    }
    return false;
  }
}

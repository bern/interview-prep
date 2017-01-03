// Given a 2D board, count how many different battleships are in it. The
// battleships are represented with 'X's, empty slots are represented with '.'s.
// You may assume the following rules:

// You receive a valid board, made of only battleships or empty slots.

// Battleships can only be placed horizontally or vertically. In other words,
// they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1
// column), where N can be of any size.

// At least one horizontal or vertical cell separates between two battleships -
// there are no adjacent battleships.

public class BattleshipBoard {
  public static void main(String[] args) {
    // char[][] board = {{'X','.','.','X'}, {'.','.','.','X'}, {'.','.','.','X'}};
    char[][] board = {{'X','X','X'}};

    System.out.println(countBattleships(board));
  }

  public static int countBattleships(char[][] board) {
    int count = 0;

    for(int r = 0; r < board.length; r++) {
      for(int c = 0; c < board[r].length; c++) {
        if(board[r][c] == 'X') {
          flood(board, r, c);
          count++;
        }
      }
    }
    return count;
  }

  public static void flood(char[][] board, int startR, int startC) {
    int r = startR;
    int c = startC;

    // Check if battleship is alone. (on border or no right+down)
    if((r+1) == board.length && (c+1) == board[0].length) {
      board[r][c] = '.';
      return;
    }

    if((r+1) < board.length && board[r+1][c] == 'X') {
      while((r < board.length) && board[r][c] == 'X') {
        board[r][c] = '.';
        r++;
      }
      return;
    }

    if((c+1) < board[0].length && board[r][c+1] == 'X') {
      while((c < board[0].length) && board[r][c] == 'X') {
        board[r][c] = '.';
        c++;
      }
      return;
    }

    board[r][c] = '.';
    return;
  }
}

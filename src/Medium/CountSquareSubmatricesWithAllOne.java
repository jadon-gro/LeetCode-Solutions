package src.Medium;
//Time complexity: O(n*m)
// n - elements in matrix
// m - max size of square

import java.util.*;
class Solution {
  public int countSquares(int[][] matrix) {
      Set<Square> squares = new HashSet<Square>();
      
      //find base squares
      int numRows = matrix.length;
      int numCols = matrix[0].length;
      
      for(int row = 0; row < numRows; row++) {
          for (int col = 0; col < numCols; col++) {
              if (matrix[row][col] == 1) squares.add(new Square(1, row, col));
          }
      }
      
      int currSize = 2;
      boolean changed = true;
      while(changed) {
          int sizeDebug = squares.size();
          changed = false;
          Set<Square> temp = new HashSet<Square>(squares);
          for(Square s : temp) {
              if (s.size == currSize - 1) {
                  int row = s.row;
                  int col = s.col;
                  if (row + currSize > numRows || col + currSize > numCols) continue;
                  int checkRow = row + currSize - 1;
                  int checkCol = col + currSize - 1;
                  boolean failed = false;
                  for(int sweep = row; sweep < checkRow; sweep++) {
                      if (!squares.contains(new Square(1, sweep, checkCol))){
                          failed = true;
                          break;
                      }
                  }
                  if (failed) continue;
                  for(int sweep = col; sweep <= checkCol; sweep++) {
                      if (!squares.contains(new Square(1, checkRow, sweep))){
                          failed = true;
                          break;
                      }
                  }
                  if (!failed){
                      squares.add(new Square(currSize, row, col));
                      changed = true;
                  }
              }
          }
          currSize++;
      }
      return squares.size();
  }
}

class Square {
  int size;
  int row;
  int col;
  public Square(int size, int row, int col) {
      this.size = size;
      this.row = row;
      this.col = col;
  }
  
  @Override
  public int hashCode() {
      return 300*size + row + 3000*col;
  }
  
  @Override
  public boolean equals(Object o) {
      if(o instanceof Square) {
          Square other = (Square) o;
          return other.size == size && other.row == row && other.col == col;
      }
      return false;
  }
  public String toString() {
      return "[Size: " + size + " At: (" + row + "," + col + ")]";
  }
}
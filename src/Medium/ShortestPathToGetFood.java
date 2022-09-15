package src.Medium;

import java.util.*;
class Solution {
  public int getFood(char[][] grid) {
      //Find me
      Coord me = null;
      int numRows = grid.length;
      int numCols = grid[0].length;
      for(int row = 0; row < numRows; row++) {
          for(int col = 0; col < numCols; col++) {
              if (grid[row][col] == '*') me = new Coord(row, col, 0);
          }
      }
      Set<Coord> visited = new HashSet<Coord>();
      Queue<Coord> q = new LinkedList<Coord>();
      q.add(me);
      int step = 0;
      while(!q.isEmpty()) {
          int size = q.size();
          for(int i = 0; i < size; i++) {
              Coord curr = q.poll();
              if (!visited.contains(curr)) {
                  visited.add(curr);
                  int row = curr.row;
                  int col = curr.col;
                  if (grid[row][col] == '#') {
                      return step;
                  }

                  if (row - 1 >= 0 && (grid[row - 1][col] == 'O' || grid[row - 1][col] == '#')) q.add(new Coord(row - 1, col, step));
                  if (col - 1 >= 0 && (grid[row][col - 1] == 'O' || grid[row][col - 1] == '#')) q.add(new Coord(row, col - 1, step));
                  if (row + 1 < numRows && (grid[row + 1][col] == 'O' || grid[row + 1][col] == '#')) q.add(new Coord(row + 1, col, step));
                  if (col + 1 < numCols && (grid[row][col + 1] == 'O' || grid[row][col + 1] == '#')) q.add(new Coord(row, col + 1, step));
              }
          }
          step++;
      }
      return -1;
  }
}

class Coord {
  int col;
  int row;
  int step;
  public Coord (int row, int col, int step) {
      this.row = row;
      this.col = col;
      this.step = step;
  }
  
  @Override
  public int hashCode() {
      return row * 200 + col;
  }
  
  @Override
  public boolean equals(Object o) {
      if (o instanceof Coord) {
          Coord temp = (Coord) o;
          return temp.row == row && temp.col == col;
      }
      return false;
  }
  
  @Override
  public String toString() {
      return "Row: " + row + " Col: " + col + " Step: " + step;
  }
}
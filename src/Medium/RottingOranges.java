package src.Medium;
// I would like to do better but for now,
// Time Complexity O(n * m) n = size of array, m = num of minutes

class Solution {
  public int orangesRotting(int[][] grid) {
      int n = grid[0].length;
      int m = grid.length;
      int[][] temp = copy(grid);
      boolean changed = true;
      int min = -1;
      while (changed){
          changed = false;
          for(int x = 0; x < m; x++) {
              for (int y = 0; y < n; y++) {
                  if (grid[x][y] == 1) {
                      //right
                      if (x + 1 < m && grid[x + 1][y] == 2){
                          temp[x][y] = 2;
                          changed = true;
                      }
                      //left
                      if (x - 1 >= 0 && grid[x - 1][y] == 2){
                          temp[x][y] = 2;
                          changed = true;
                      }
                      //down
                      if (y - 1 >= 0 && grid[x][y - 1] == 2){
                          temp[x][y] = 2;
                          changed = true;
                      }
                      //up
                      if (y + 1 < n && grid[x][y + 1] == 2){
                          temp[x][y] = 2;
                          changed = true;
                      }
                  }
              }
          }
          min++;
          grid = copy(temp);
      }
      for (int x = 0; x < m; x++) {
          for (int y = 0; y < n; y++) {
              if (grid[x][y] == 1) return -1;
          }
      }
      return min;
  }
  
  public int[][] copy(int[][] toCopy) {
      int n = toCopy[0].length;
      int m = toCopy.length;
      int[][] copy = new int[m][n];
      for(int i = 0; i < n; i++) {
          for (int j = 0; j < m; j++) {
              copy[j][i] = toCopy[j][i];
          }
      }
      return copy;
  }
  
}

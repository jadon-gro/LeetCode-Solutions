package src.Medium;
// Time Complexity: O(n*m)

import java.util.*;
class Solution {
  Set<Coord> checked;
  int n;
  int m;
  char[][] grid;
  public int numIslands(char[][] grid) {
      this.grid = grid;
      checked = new HashSet<Coord>();
      n = grid[0].length;
      m = grid.length;
      int islandCount = 0;
      for (int y = 0; y < n; y++) {
          for (int x = 0; x < m; x++) {
              if (grid[x][y] == '0' || checked.contains(new Coord(x,y))) continue;
              fillIsland(new Coord(x, y));
              islandCount++;
          }
      }
      return islandCount;
  }
  public void fillIsland(Coord point) {
      int x = point.x;
      int y = point.y;
      if (grid[x][y] == '1'){
          checked.add(point);
          Coord left = new Coord(Math.max(x - 1, 0), y);
          Coord right = new Coord(Math.min(x + 1, m - 1), y);
          Coord up = new Coord(x, Math.min(y + 1, n - 1));
          Coord down = new Coord(x, Math.max(y - 1, 0));
          if (!checked.contains(left)) {
              fillIsland(left);
          }
          if (!checked.contains(right)) {
              fillIsland(right);
          }
          if (!checked.contains(up)) {
              fillIsland(up);
          }
          if (!checked.contains(down)) {
              fillIsland(down);
          }
      }
  }
}

class Coord {
  int x;
  int y;
  Coord (int x, int y) {
      this.x = x;
      this.y = y;
  }
  @Override
  public boolean equals(Object o) {
      if (o instanceof Coord) {
          Coord oPoint = (Coord) o;
          if (oPoint.x == x && oPoint.y == y) return true;
      }
      return false;
  }
  @Override
  public int hashCode() {
      return x + 1000*y;
  }
}
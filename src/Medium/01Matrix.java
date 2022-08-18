package src.Medium;
// Time Complexity: O(c*r*h)
// c = columns
// r = rows
// h = height (maximum number)
// this approach is not ideal

class Solution {
  public int[][] updateMatrix(int[][] mat) {
      boolean changed = false;
      int n = mat[0].length;
      int m = mat.length;
      while (true) {
          for (int i = 0; i < m; i++) {
              for (int j = 0; j < n; j++) {
                  int curr = mat[i][j];
                  if (curr == 0) continue;
                  int up = (j + 2) > n ? Integer.MAX_VALUE : mat[i][j + 1];
                  int down = (j - 1) < 0 ? Integer.MAX_VALUE : mat[i][j - 1];
                  int right = (i + 2) > m ? Integer.MAX_VALUE : mat[i + 1][j];
                  int left = (i - 1) < 0 ? Integer.MAX_VALUE : mat[i - 1][j];
                  int val = Math.min(up, Math.min(down, Math.min(right, left))) + 1;
                  if (val != curr) {
                      changed = true;
                      mat[i][j] = val;
                  }
              }
          }
          if (!changed) {
              break;
          }
          changed = false;
      }
      return mat;
  }
}
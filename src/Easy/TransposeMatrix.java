package src.Easy;
// Time Complexity: O(n)

class Solution {
  public int[][] transpose(int[][] matrix) {
      int columns = matrix[0].length;
      int rows = matrix.length;
      int[][] transposed = new int[matrix[0].length][matrix.length];
      for (int n = 0; n < columns; n++) {
          for (int m = 0; m < rows; m++) {
              transposed[n][m] = matrix[m][n];
          }
      }
      return transposed;
  }
}
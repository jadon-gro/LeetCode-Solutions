package src.Medium;
// Time Complexity: O(n)

class Solution {
  public int uniquePaths(int m, int n) {
      int[][] dp = new int[m][n];
      for (int i = 1; i < n; i++) {
          dp[0][i] = 1;
      }
      for (int i = 0; i < m; i++) {
          dp[i][0] = 1;
      }
      for (int i = 1; i < Math.min(m,n); i++) {
          for (int j = i; j < n; j++) {
              dp[i][j] = dp[i-1][j] +dp[i][j - 1];
          }
          for (int j = i + 1; j < m; j++) {
              dp[j][i] = dp[j][i - 1] +dp[j - 1][i];
          }
      }
      return dp[m-1][n-1];
  }
}
package src.Medium;
// Time Complexity: O(nm)

import java.lang.Math;
class Solution {
  public int longestCommonSubsequence(String text1, String text2) {
      int n = text1.length();
      int m = text2.length();
      int[][] dp = new int[m + 1][n + 1];
      for (int i = 1; i < m + 1; i++) {
          for (int j = 1; j < n + 1; j++) {
              if (text1.charAt(j-1) == text2.charAt(i-1)) {
                  dp[i][j] =  dp[i - 1][j - 1] + 1;
              } else {
                  dp[i][j] = dp[i][j - 1] >  dp[i - 1][j] ? dp[i][j - 1] : dp[i - 1][j];
              }
          }
      }
      return dp[m][n];
  }
}
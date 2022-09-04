package src.Medium;

class Solution {
  public int findTargetSumWays(int[] nums, int target) {
      int total = 0;
      for (int i : nums) total += i;
      if (Math.abs(target) > total) return 0;
      int len = nums.length;
      int dp[][] = new int[len][total * 2 + 1];
      dp[0][nums[0] + total] = 1;
      dp[0][-nums[0] + total] += 1;
      for(int i = 1; i < len; i++) {
          int curr = nums[i];
          for (int j = -total; j <= total; j++) {
              if (dp[i - 1][j + total] > 0) {
                  dp[i][j + curr +total] += dp[i - 1][j + total];
                  dp[i][j - curr + total] += dp[i - 1][j + total];
              }
          }
      }
      return dp[len - 1][target + total];
  }
}
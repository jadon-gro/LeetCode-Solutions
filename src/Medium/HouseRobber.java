package src.Medium;
// Time Complexity: O(n)

class Solution {
  public int rob(int[] nums) {
      int len = nums.length;
      if (len == 2) return Math.max(nums[0], nums[1]);
      if (len == 1) return nums[0];
      int[] dp = new int[len];
      dp[0] = nums[0];
      dp[1] = nums[1];
      dp[2] = nums[0] + nums[2];
      for(int i = 3; i < len; i++) {
          dp[i] = Math.max(dp[i - 2],dp[i - 3]) + nums[i];
      }
      return Math.max(dp[len - 1], dp[len - 2]);
  }
}
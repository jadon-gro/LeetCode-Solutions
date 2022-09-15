package src.Medium;
// Time Complexity: O(n)

import java.util.Arrays;
class Solution {
  public int lengthOfLIS(int[] nums) {
      int max = 1;
      int len = nums.length;
      int maxNum = Integer.MIN_VALUE;
      int[] dp = new int[len];
      Arrays.fill(dp, 1);
      for(int i = len - 2; i >= 0; i--) {
          int curr = nums[i];
          maxNum = Math.max(curr, maxNum);
          if (curr > maxNum) continue;
          
          for(int j = i + 1; j < len; j++) {
              if (nums[j] > nums[i]) {
                  max = Math.max(max, dp[j] + 1);
                  dp[i] = Math.max(dp[j] + 1, dp[i]);
              }
          }
      }
      return max;
  }
}
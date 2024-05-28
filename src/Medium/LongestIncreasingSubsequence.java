package src.Medium;
// Time Complexity: O(n^2)

import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
      int max = 0;
      int len = nums.length;
      int[] dp = new int[len];
      Arrays.fill(dp, 1);
      for(int i = 0; i < len; i++) {
          max = dp[i];
          for(int j = 0; j < i; j++) {
              if (nums[j] < nums[i]) {
                  max = Math.max(max, dp[j] + 1);
                  dp[i] = Math.max(dp[j] + 1, dp[i]);
              }
          }
      }
      for (int i : dp) {
          max = Math.max(max, i);
      }
      return max;
    }
  }
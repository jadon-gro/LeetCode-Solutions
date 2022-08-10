package src.Medium;
// Time Complexity: O(n)

class Solution {
  public int maxSubArray(int[] nums) {
      int max = nums[0];
      int curr = nums[0];
      for (int i = 1; i < nums.length; i++) {
          int num = nums[i];
          curr = Math.max(num, curr+num);
          max = Math.max(curr, max);
      }
      return max;
      
  }
}
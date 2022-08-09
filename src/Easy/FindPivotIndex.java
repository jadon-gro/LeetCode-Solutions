package src;
// Time Complexity: O(n)

class Solution {
  public int pivotIndex(int[] nums) {
      int lsum = 0;
      int sum = 0;
      int len = nums.length;
      for (int i : nums) {sum += i;}
      
      for(int i = 0; i < len; i++) {
          int curr = nums[i];
          if (sum - curr == lsum) return i;
          sum -= curr;
          lsum += curr;
          
      }
      return -1;
      
  }
}
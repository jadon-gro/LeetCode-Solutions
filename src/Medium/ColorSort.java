package src.Medium;
// Time Complexity: O(n)
// Had to reference the solution. I initially implemented bubble sort which worked.

class Solution {
  public void sortColors(int[] nums) {
      int p0 = 0;
      int p2 = nums.length - 1;
      int curr = 0;
      while (curr <= p2) {
          int val = nums[curr];
          if (val == 0) {
              int temp = nums[p0];
              nums[p0] = val;
              nums[curr] = temp;
              curr++;
              p0++;
          }
          if (val == 2) {
              int temp = nums[p2];
              nums[p2] = val;
              nums[curr] = temp;
              p2--;
          }
          if (val == 1) {
              curr++;
          }
      }
  }
}
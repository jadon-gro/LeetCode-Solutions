package src.Easy;
// Time Complexity: O(n)

class Solution {
  public int removeDuplicates(int[] nums) {
      int k = 1;
      for (int i : nums) {
          if (i > nums[k - 1]) {
              nums[k] = i;
              k++;
          }
      }
      return k;
  }
}
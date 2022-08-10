package src.Easy;
// Time Complexity: O(n)

import java.util.Arrays;
class Solution {
  public int majorityElement(int[] nums) {
      Arrays.sort(nums);
      int curr = 0;
      int last = -1;
      int cap = nums.length / 2;
      for(int i : nums) {
          if (i != last) curr = 0;
          last = i;
          curr++;
          if (curr > cap) {
              return i;
          }
      }
      return -1;
  }
}
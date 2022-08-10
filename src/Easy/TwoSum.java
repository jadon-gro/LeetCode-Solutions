package src.Easy;
// Time Complexity: O(n)

import java.util.*;
class Solution {
  public int[] twoSum(int[] nums, int target) {
      HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
      
      for(int i = 0; i < nums.length; i++) {
          map.put(nums[i], i);
      }
      
      for(int i = 0; i < nums.length; i++) {
          int val = map.getOrDefault(target - nums[i], -1);
          if (val != -1 && val != i) {
              return new int[]{i, val};
          }
      }
      return null;
  }
}
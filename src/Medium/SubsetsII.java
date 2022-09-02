package src.Medium;

import java.util.*;
class Solution {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
      Set<List<Integer>> response = new HashSet<List<Integer>>();
      int ul = (int) Math.pow(2 ,nums.length);
      for (int i = 0; i < ul; i++) {
          int mask = i;
          List<Integer> curr = new ArrayList<Integer>();
          int counter = 0;
          while (mask != 0) {
              if ((mask & 1 )== 1) curr.add(nums[counter]);
              mask = mask >> 1;
              counter++;
          }
          Collections.sort(curr);
          response.add(curr);
      }
      return new ArrayList<List<Integer>>(response);
  }
}

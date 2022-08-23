package src.Medium;

import java.util.*;
class Solution {
  int[] nums;
  int len;
  List<List<Integer>> result;
  public List<List<Integer>> permute(int[] nums) {
      result = new ArrayList<List<Integer>>();
      this.nums = nums;
      this.len = nums.length - 1;
      backTracking(new LinkedList<Integer>());
      return result;
      
  }
  public void backTracking(LinkedList<Integer> comb) {
      if (comb.size() == len + 1) {
          result.add(new ArrayList(comb));
      }
      for (int i = 0; i <= len; i++) {
          if (!comb.contains(nums[i])) {
              comb.add(nums[i]);
              backTracking(comb);
              comb.removeLast();
          }
      }
  }
}
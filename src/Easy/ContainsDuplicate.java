package src.Easy;
// Time Complexity: O(n)

import java.util.HashSet;
class Solution {
  public boolean containsDuplicate(int[] nums) {
      HashSet<Integer> s = new HashSet<Integer>();
      for(int i : nums) if (!s.add(i)) return true;
      return false;
  }
}
package src;
// Time Complexity: O(n)

import java.util.*;
class Solution {
  public int lengthOfLongestSubstring(String s) {
      int left = 0;
      int right = 0;
      int max = 0;
      HashMap<Character,Integer> lastOccuranceTable = new HashMap<Character,Integer>();
      while(right < s.length()) {
          Integer lastOccurance = lastOccuranceTable.put(s.charAt(right), right);
          if (lastOccurance != null && lastOccurance >= left) {
              left = lastOccurance + 1;
          }
          if (right - left + 1> max) {
              max = right - left + 1;
          }
          right++;
      }
      return max;
  }
}
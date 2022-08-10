package src.Easy;
// Time Complexity: O(n)

import java.util.HashMap;
class Solution {
  public int longestPalindrome(String s) {
      HashMap<Character, Integer> chars = new HashMap<Character, Integer>();
      for(int i = 0; i < s.length(); i++) {
          char curr = s.charAt(i);
          chars.put(curr, chars.getOrDefault(curr, 0) + 1);
      }
      boolean oneLeftOver = false;
      int runningTotal = 0;
      for (char c : chars.keySet()){
          int amt = chars.get(c);
          runningTotal += amt / 2;
          if (amt % 2 == 1) {
              oneLeftOver = true;
          }
      }
      runningTotal = runningTotal * 2;
      if (oneLeftOver) runningTotal++;
      return runningTotal;
  }
}
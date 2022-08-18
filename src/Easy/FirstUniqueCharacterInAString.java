package src.Easy;
// Time Complexity: O(n)

import java.util.HashMap;
class Solution {
  public int firstUniqChar(String s) {
      HashMap<Character, Integer> counter = new HashMap<Character, Integer>();
      int len = s.length();
      for (int i = 0; i < len; i++) {
          char curr = s.charAt(i);
          counter.put(curr, counter.getOrDefault(curr, 0) + 1);
      }
      for (int i = 0; i < len; i++) {
          if (counter.get(s.charAt(i)) == 1) {
              return i;
          }
      }
      return -1;
  }
}
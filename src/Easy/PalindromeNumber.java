package src.Easy;
// Time Complexity: O(n)

import java.util.*;
class Solution {
  public boolean isPalindrome(int x) {
      if (x < 0) {
          return false;
      }
      List<Integer> list = new ArrayList<Integer>();
      int running = x;
      int digits = 0;
      while (running != 0) {
          list.add(running % 10);
          running = running / 10;
          digits++;
      }
      for (int i = 0; i < digits / 2 + digits % 2; i++) {
          if (list.get(i) != list.get(digits - i - 1)) {
              return false;
          }
      }
      return true;
  }
}
package src.Easy;
// Time Complexity: O(n)

class Solution {
  public int mostWordsFound(String[] sentences) {
      int max = 0;
      for(String s : sentences) {
          if (s.length() == 0) continue;
          int counter = 1;
          for (char c : s.toCharArray()) {
              if (c == ' ') counter++;
          }
          max = Math.max(counter, max);
      }
      return max;
  }
}
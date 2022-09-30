package src.Medium;
//Time Complexity: O(n)

class Solution {
  public int lengthOfLongestSubstringTwoDistinct(String s) {
      int len = s.length();
      if (len < 3) return len;
      char c1 = s.charAt(0);
      char c2 = '-';
      int i;
      for(i = 1; i < len; i++) {
          if (s.charAt(i) != c1) {
              c2 = s.charAt(i);
              break;
          }
      }
      if (c2 == '-') return len;
      int lastSwitch = i;
      int res = i + 1;
      int currlen = i + 1;
      for(int pos = i + 1; pos < len; pos++) {
          char c = s.charAt(pos);
          if (c != c2) {
              if (c != c1) {
                  currlen = pos - lastSwitch;
              }
              lastSwitch = pos;
              c1 = c2;
              c2 = c;
          }
          currlen++;
          res = Math.max(currlen, res);
      }
      return res;
  }
}

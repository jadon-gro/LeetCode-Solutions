package src.Medium;
// Time complexity: O(n*m) n = size of string, n = average size of palendrome
class Solution {
  public String longestPalindrome(String s) {
      int max = 0;
      if (s.length() == 0) return "";
      String response = s.substring(0,1);
      char[] cs = s.toCharArray();
      for(int i = 0; i < cs.length; i++) {
          int right = i;
          int left = i;
          boolean changed = true;
          while (changed){
              changed = false;
              if (left - 1 >= 0 && cs[left - 1] == cs[left]) {
                  left--;
                  changed = true;
              }
              if (right + 1 < cs.length && cs[right + 1] == cs[right]) {
                  right++;
                  changed = true;
              }
              if ((right - left) > max) {
                  max = right - left;
                  response = s.substring(left, right + 1);
              }
          }
          while (++right < cs.length && --left >= 0 && cs[right] == cs[left]) {
              if ((right - left) > max) {
                  max = right - left;
                  response = s.substring(left, right + 1);
              }
          }
          
      }
      return response;
  }
} 
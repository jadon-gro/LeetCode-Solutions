package src;
// Time Complexity: O(n)

class Solution {
  public boolean isPalindrome(String s) {
      StringBuilder sb = new StringBuilder();
      for(int i = 0; i < s.length(); i++) {
          char c = s.charAt(i);
          if (Character.isLetter(c) || Character.isDigit(c)) sb.append(Character.toLowerCase(c));
      }
      int len = sb.length();
      for(int i = 0; i < len / 2; i++) {
          if(sb.charAt(i) != sb.charAt(len - i - 1)) return false;
      }
      return true;
  }
}
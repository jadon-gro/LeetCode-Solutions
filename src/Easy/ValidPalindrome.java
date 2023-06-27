package src.Easy;
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


//Second solution with one pass
class Solution2 {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            while (l < r && isSpecial(s.charAt(l))) l++;
            while (l < r && isSpecial(s.charAt(r))) r--;
            if (l > r) break;
            if (isEqualIgnoreCase(s.charAt(l), s.charAt(r))) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;

    }

    private boolean isSpecial(char c) {
        return (c < 48 || c > 57 && c < 65 || c > 90 && c < 97 || c > 122);
    }

    private boolean isEqualIgnoreCase(char l, char r) {
        return (l == r || r > 96 && l == r - 32 || l > 96 && r == l - 32);
    }
}
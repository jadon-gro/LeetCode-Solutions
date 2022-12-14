package src.Medium;
// Time Complexity: O(n)

class Solution {
  public int reverse(int x) {
      int rev = 0;
      while (x != 0) {
          int pop = x % 10;
          x = x / 10;
          if (rev > Integer.MAX_VALUE/10 || rev < Integer.MIN_VALUE/10 ||
              rev == Integer.MAX_VALUE/10 && pop > 7 ||
             rev == Integer.MIN_VALUE/10 && pop < -8) return 0;
          rev = rev * 10 + pop;
      }
      return rev;
  }
}
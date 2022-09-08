package src.Easy;
// Time Complexity: O(n)

class Solution {
  public int[] plusOne(int[] digits) {
      int len = digits.length;
      if (digits[len - 1] != 9) {
          digits[len - 1] = digits[len - 1] + 1;
          return digits;
      } else {
          int i = len - 1;
          boolean makeNew = false;
          while(digits[i] == 9) {
              digits[i] = 0;
              i--;
              if (i == -1) {
                  makeNew = true;
                  digits[0] = 1;
                  break;
              }
              
          }
          if (makeNew) {
              int[] rv = new int[len + 1];
              rv[0] = 1;
              return rv;
          }
          digits[i] = digits[i] + 1;
          return digits;
      }
  }
}

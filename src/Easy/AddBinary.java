package src.Easy;
// Time Complexity O(n)

class Solution {
  public String addBinary(String a, String b) {
      boolean carry = false;
      StringBuilder response = new StringBuilder();
      int aL = a.length();
      int bL = b.length();
      int cap = Math.max(aL, bL) + 1;
      for(int i = 1; i <= cap; i++) {
          boolean aC, bC;
          try {
              aC = a.charAt(aL - i) == '1';
          } catch(IndexOutOfBoundsException e) {
              aC = false;
          }
          try {
              bC = a.charAt(bL - i) == '1';
          } catch(IndexOutOfBoundsException e) {
              bC = false;
          }
          if (carry && aC && bC) {
              response.append('1');
              carry = true;
          } else if (aC && bC || carry && aC || carry && bC) {
              response.append('1');
              carry = false;
          } else {
              response.append('0');
              carry = false;
          }
      }
      if (carry) response.append('1');
      return response.toString();
  }
}
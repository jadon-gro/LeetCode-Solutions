package src;
// Time Complexity: O(n)

class Solution {
  public int maxProfit(int[] prices) {
      int min = Integer.MAX_VALUE;
      int maxprofit = 0;
      for(int i : prices) {
          if (i < min) {
              min = i;
          }
          int p = i - min;
          if (p > maxprofit) {
              maxprofit = p;
          }
      }
      return maxprofit;
  }
}

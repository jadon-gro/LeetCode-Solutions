package src.Easy;
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


// also O(n). Just D&C recursive instead.
class Solution2 {
    int maxP = 0;
    public int maxProfit(int[] prices) {
        int[] ans = soln(0, prices.length, prices);
        return maxP;
    }

    public int[] soln(int l, int r, int[] p) {
        
        if (l + 1 == r) {
            int[] rv = {p[l], p[l]};
            return rv;
        }
        int[] ls = soln(l, (l + r)/2, p);
        int[] rs = soln((l + r)/2, r, p);
        maxP = Math.max(maxP, rs[1] - ls[0]);
        int[] rv = {Math.min(ls[0], rs[0]), Math.max(ls[1], rs[1])};
        return rv;
    }
}
package src.Medium;
// Time Complexity: O(n)
// The proof behind this is hard. I couldn't figure it out without looking at the solution :/

class Solution {
  public int maxArea(int[] height) {
      int left = 0;
      int right = height.length - 1;
      int max = -1;
      while (right > left) {
          int rh = height[right];
          int lh = height[left];
          max = Math.max(max, (right - left) * Math.min(rh,lh));
          if (lh <= rh) {
              left++;
          } else {
              right--;
          }
      }
      return max;
  }
}
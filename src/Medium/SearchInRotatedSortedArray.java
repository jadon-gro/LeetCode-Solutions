package src.Medium;
// Time Complexity: O(n)

class Solution {
  public int search(int[] nums, int target) {
      int len = nums.length;
      int min = 0;
      int max = len - 1;
      while (max >= min) {
          int midIndex = min + (max - min) / 2;
          int left = nums[min];
          int right = nums[max];
          int mid = nums[midIndex];
          if (target == mid) return midIndex;
          if (left <= mid) {
              if (target >= left && target < mid) max = midIndex - 1;
              else min = midIndex + 1;
          } else {
              if (target > mid && target <= right) min = midIndex + 1;
              else max = midIndex - 1;
          }
      }
      return -1;
  }
}
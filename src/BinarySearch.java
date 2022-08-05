package src;
// Time Complexity: O(logn)

class Solution {
  public int search(int[] nums, int target) {
      int len = nums.length;
      int i = (len - 1) / 2;
      int iprev = -1;
      int max = len;
      int min = 0;
      int output = -1;
      while (i != iprev) {
          if (nums[i] == target) {
              output = i;
              break;
          } else if (nums[i] < target) {
              iprev = i;
              min = i;
              i = i + ((max - i) / 2);
          } else {
              iprev = i;
              max = i;
              i = i - ((i - min + 1) / 2);
          }
      }
      return output;
  }
}
package src.Medium;
// Time Complexity: O(n)

class Solution {
  public int[] productExceptSelf(int[] nums) {
      int total = 1;
      boolean zero = false;
      int len = nums.length;
      for(int num : nums) {
          if (num != 0) {
              total = total * num;
          } else if (!zero) {
              zero = true;
          } else {
              return new int[len];
          }
      }
      int[] rv = new int[len];
      if (zero) {
          for (int i = 0; i < len; i++) {
              if (nums[i] == 0) {
                  rv[i] = total;
                  break;
              }
          }
          return rv;
      }
      for (int i = 0; i < len; i++) {
          rv[i] = total / nums[i];
      }
      return rv;
      
      
  }
}

package src.Medium;
import java.util.*;

// Time Complexity: O(n)
class InteligentSequenceFinder {
  public int longestConsecutive(int[] nums) {
      int len = nums.length;
      if (len == 1 || len == 0) return len;
      Set<Integer> set = new HashSet<Integer>();
      for(int i : nums) set.add(i);
      int max = 1;
      for(int i : set) {
          if (!set.contains(i - 1)) {
              int curr = 1;
              int num = i;
              while (set.contains(num + 1)) {
                  curr++;
                  num++;
                  
              }
              max = Math.max(curr, max);
          }
      }
      return max;
  }
}


// Time Complexity: O(nlogn)
class Sorting {
  public int longestConsecutive(int[] nums) {
      Arrays.sort(nums);
      if (nums.length == 0 || nums.length == 1) return nums.length;
      int max = 1;
      int curr = 1;
      for (int i = 0; i < nums.length - 1; i++) {
          if (nums[i] == nums[i + 1]) continue;
          if (nums[i] == nums[i + 1] - 1) {
              curr++;
              max = Math.max(max, curr);
          } else {
              curr = 1;
          }
      }
      return max;
  }
}



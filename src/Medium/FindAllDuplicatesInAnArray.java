package src.Medium;
// Time Complexity: O(n)
// Also in place

import java.util.*;
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> response = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++) {
            nums[Math.abs(nums[i]) - 1] *= -1;
            if (nums[Math.abs(nums[i]) - 1] > 0) response.add(Math.abs(nums[i]));
        }
        return response;
    }
}

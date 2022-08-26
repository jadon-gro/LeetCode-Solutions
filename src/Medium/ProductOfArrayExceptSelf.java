package src.Medium;
// Time Complexity: O(n)

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int total = 1;
        boolean zero = false;
        int len = nums.length;
        int[] rv = new int[len];
        rv[0] = 1;
        for (int i = 1; i < len; i++) {
            rv[i] = nums[i - 1] * rv[i - 1];
        }
        int right = 1;
        for (int i = len - 1; i >= 0; i--) {
            rv[i] = rv[i] * right;
            right = right * nums[i];
        }
        return rv;
        
    }
}